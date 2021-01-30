import java.util.Random;

public class Tablero {
	//variables de instancia
	private Celda[][] celdas ;
	private Boolean perdio;
	private Boolean gano;
	private int puntajes;
	private boolean movio;
	private int[][] arrayJugadaPrevia;
	private int puntajePrevio;
	
	//constructor
	public Tablero (int tamao ) {
		this.arrayJugadaPrevia=new int[tamao][tamao];
		this.celdas = new Celda[tamao][tamao];
		this.setPerdio(false);
		this.setGano(false);
		this.setPuntajes(0);
		for(int i=0;i<tamao; i++) {
			for(int j=0;j<tamao;j++) {
				this.celdas[i][j] = new Celda(0);
			}
		}
	}

	//metodo para crear el tablero
	public Tablero (int[][] matriz ) {
		this.arrayJugadaPrevia=new int[matriz.length][matriz.length];
		this.celdas = new Celda[matriz.length][matriz.length];
		this.setPerdio(false);
		this.setGano(false);
		this.setPuntajes(0);
		for(int i=0;i<matriz.length; i++) {
			for(int j=0;j<matriz.length;j++) {
				this.celdas[i][j] = new Celda(matriz[i][j]);
			}
		}
	}
	
	// Copia el tablero en una matriz
	private int[][] copiarEnMatriz()
	{
		int[][] ret=new int[this.getTamaño()][this.getTamaño()];
		for (int i=0;i<ret.length;i++)
		{
			for (int j=0;j<ret.length;j++)
			{
				ret[i][j]=this.celdas[i][j].ObtenerValor();
			}
		}
		return ret;
	}
	
	//duplica la matriz para el paso anterior
	private int[][] copiarMatriz(int[][] matriz) 
	{
		int[][] ret=new int[matriz.length][matriz.length];
		for (int i=0;i<matriz.length;i++)
		{
			for (int j=0;j<matriz.length;j++)
			{
				ret[i][j]=matriz[i][j];
			}
		}
		return ret;
	}
	
	//Copia la matriz en un array
	public void  jugadaPrevia()
	{
		arrayJugadaPrevia=this.copiarEnMatriz();
	}
	
	public Tablero deshacerMovimiento()
	{
		int puntaje = this.getPuntajePrevio();
		Tablero ret = new Tablero(arrayJugadaPrevia);
		ret.setPuntajes(puntaje);
		return ret;
	}
	
	public void iniciarPartida()
	{
		InsertarValorRandom();
		InsertarValorRandom();
		this.jugadaPrevia();
	}
	
	private int[] BuscarPosLibre() {
		 
		Random valorRandom= new Random();
		int posX=valorRandom.nextInt(getTamaño());
		int posY=valorRandom.nextInt(getTamaño());
		while(!this.celdas[posX][posY].celdaVacia() && this.contarLugaresVacios()>0) {
			posX=valorRandom.nextInt(getTamaño());
			posY=valorRandom.nextInt(getTamaño());
			
		}
		
		return new int[]{posX,posY};
	}
	
	private void InsertarValorRandom() 
	{
		if (this.contarLugaresVacios()>0)
		{
			int[] posiciones=BuscarPosLibre();
			celdas[posiciones[0]][posiciones[1]].asignarValorRandom();
		}
			
	}
	
	public void moverPieza(int filaOrigen,int colOrigen, int filaDestino, int colDestino)
	{
		if (esValida(filaOrigen) && esValida(colOrigen) && esValida(filaDestino) && esValida(colDestino))
		{
			if ((filaOrigen==filaDestino)&&(colOrigen==colDestino))
			{
				
				throw new RuntimeException("error no pueden ser iguales");
			}
			else
			{
				this.celdas[filaDestino][colDestino].AsignarValor(this.celdas[filaOrigen][colOrigen].ObtenerValor());
				this.celdas[filaOrigen][colOrigen].AsignarValor(0);
			}
		}
		else
		{
			throw new RuntimeException("error posicion fuera de rango");
		}
	}
	
	private void colision(int filaOrigen, int colOrigen, int filaDestino, int colDestino) 
	{
		if (esValida(filaOrigen) && esValida(colOrigen) && esValida(filaDestino) && esValida(colDestino))
		{
			if (!celdas[filaDestino][colDestino].getCollision())
			{
				celdas[filaDestino][colDestino].sumarValor();
				celdas[filaDestino][colDestino].Collision(true);
				celdas[filaOrigen][colOrigen].AsignarValor(0);
				this.puntajePrevio = this.puntajes;
				this.puntajes=this.puntajes + celdas[filaDestino][colDestino].ObtenerValor();
				this.verificar2048(celdas[filaDestino][colDestino].ObtenerValor());
			}	
			
		}
		else
		{
			
			throw new RuntimeException("error posicion fuera de rango");
				}
	}
	
	public void verificar2048(int valor) {
		if(valor==2048)
		{
			this.setGano(true);
			System.out.println("GANASTE");
		}
		
		
	}
		
	private boolean esValida(int coor) 
	{
		return (coor>=0 || coor < this.getTamaño());
	}
	
	public void arriba()
	{
		int[][] aux;
		aux=copiarMatriz(this.arrayJugadaPrevia);
		this.jugadaPrevia();
		for(int fila =1; fila<this.getTamaño();fila++) 
		{
			for(int col=0;col<this.getTamaño();col++) 
			{
					subirPieza(fila, col);	
			}			
		}
		if (this.movio)
		{
			this.InsertarValorRandom();
			this.movio=false;
		}
		else
		{	this.arrayJugadaPrevia=copiarMatriz(aux);
			System.out.println("no es posible ese movimiento");			
		}

		
		
		this.ResetearChoque();
	}
	
	private void subirPieza(int fila, int col)
	{
		if (fila>0&&!celdas[fila][col].celdaVacia())
		{
			if (celdas[fila-1][col].celdaVacia())
			{
				moverPieza(fila,col,fila-1,col);
				subirPieza(fila-1,col);
				this.movio=true;
			}
			else
			{
				if (celdas[fila-1][col].verificarIgualdad(celdas[fila][col].ObtenerValor()))
				{
					 colision(fila,col,fila-1,col);	
					 this.movio=true;
				}
			}
		}
	}
	
	private void bajarPieza(int fila, int col)
	{
		if (fila<this.getTamaño()-1 &&!celdas[fila][col].celdaVacia())
		{
			if (celdas[fila+1][col].celdaVacia())
			{
				moverPieza(fila,col,fila+1,col);
				bajarPieza(fila+1,col);
				this.movio=true;
			}
			else
			{
				if (celdas[fila+1][col].verificarIgualdad(celdas[fila][col].ObtenerValor()))
				{
					 colision(fila,col,fila+1,col);
					 this.movio=true;
				}
			}
		}
	}
	
	public void abajo()
	{
		int[][] aux;
		aux=copiarMatriz(this.arrayJugadaPrevia);
		this.jugadaPrevia();
		for(int fila =this.getTamaño()-2; fila>=0;fila--) 
		{
			for(int col=0;col<this.getTamaño();col++) 
			{
					bajarPieza(fila, col);	
			}			
		}
		if (this.movio)
		{
			this.InsertarValorRandom();
			this.movio=false;
		}
		else
		{
			this.arrayJugadaPrevia=copiarMatriz(aux);
			System.out.println("no es posible ese movimiento");			
		}
		this.ResetearChoque();
	}
	
	private void aLaDerechaPieza(int fila, int col)
	{
		if (col<this.getTamaño()-1 && !celdas[fila][col].celdaVacia())
		{
			if (celdas[fila][col+1].celdaVacia())
			{
				moverPieza(fila,col,fila,col+1);
				aLaDerechaPieza(fila,col+1);
				this.movio=true;
			}
			else
			{
				if (celdas[fila][col+1].verificarIgualdad(celdas[fila][col].ObtenerValor()))
				{
					 colision(fila,col,fila,col+1);	
					 this.movio=true;
				}
			}
		}
	}
	
	public void derecha()
	{
		int[][] aux;
		aux=copiarMatriz(this.arrayJugadaPrevia);
		this.jugadaPrevia();
		for(int col =this.getTamaño()-2; col>=0;col--) 
		{
			for(int fila=0;fila<this.getTamaño();fila++) 
			{
					aLaDerechaPieza(fila, col);	
			}			
		}
		if (this.movio)
		{
			this.InsertarValorRandom();
			this.movio=false;
		}
		else
		{
			this.arrayJugadaPrevia=copiarMatriz(aux);
			System.out.println("no es posible ese movimiento");			
		}

		this.ResetearChoque();
	}
	
	private void aLaIzquierdaPieza(int fila, int col)
	{
		if (col>0 && !celdas[fila][col].celdaVacia())
		{
			if (celdas[fila][col-1].celdaVacia())
			{
				moverPieza(fila,col,fila,col-1);
				aLaIzquierdaPieza(fila,col-1);
				this.movio=true;
			}
			else
			{
				if (celdas[fila][col-1].verificarIgualdad(celdas[fila][col].ObtenerValor()))
				{
					 colision(fila,col,fila,col-1);	
					 this.movio=true;
				}
			}
		}
	}
	
	public void izquierda()
	{
		int[][] aux;
		aux=copiarMatriz(this.arrayJugadaPrevia);
		this.jugadaPrevia();
		for(int col =1; col<this.getTamaño();col++) 
		{
			for(int fila=0;fila<this.getTamaño();fila++) 
			{
					aLaIzquierdaPieza(fila, col);	
			}			
		}
		if (this.movio)
		{
			this.InsertarValorRandom();
			this.movio=false;
		}
		else
		{
			this.arrayJugadaPrevia=copiarMatriz(aux);
			System.out.println("no es posible ese movimiento");			
		}

		this.ResetearChoque();
	}
		
	private void ResetearChoque() {
		for (int x=0; x < this.celdas.length; x++) {
			  for (int y=0; y < this.celdas[x].length; y++) {
			    this.celdas[x][y].Collision(false);
			  }
			}
	}
	
	public void mostrarTablero() {
		for (int x=0; x < this.celdas.length; x++) {
			  System.out.print("\n\n| ");
			  for (int y=0; y < this.celdas[x].length; y++) {
			    System.out.print (this.celdas[x][y].ObtenerValor());
			    if (y!=this.celdas[x].length-1) System.out.print("\t");
			  }
			  System.out.println("|");
			}
		System.out.print("\n ------"+"puntos= "+this.puntajes+"------ ");
	}
	
	public void mostrarPrevio() {
		for (int x=0; x < this.arrayJugadaPrevia.length; x++) {
			  System.out.print("\n\n| ");
			  for (int y=0; y < this.arrayJugadaPrevia.length; y++) {
			    System.out.print (this.arrayJugadaPrevia[x][y]);
			    if (y!=this.arrayJugadaPrevia[x].length-1) System.out.print("\t");
			  }
			  System.out.println("|");
			}
		System.out.print("\n ------"+"puntos= "+this.puntajes+"------ ");
	}
	
	public void asignarValor (int fila, int col, int valor) {
		this.celdas[fila][col].AsignarValor(valor);	
	}
	
	private int contarLugaresVacios()
	{
		int ret=0;
		for (int fila=0; fila<this.getTamaño();fila++)
		{
			for (int col=0; col<this.getTamaño();col++ )
			{
				if (celdas[fila][col].celdaVacia())
					ret++;
			}
		}
		return ret;
	}
	
	private boolean colisionPosibleEnFila(int fila)
	{
		boolean ret=false;
		
		for (int col=0; col<this.getTamaño()-1 && !ret;col++)
		{
			if (!celdas[fila][col].celdaVacia())
			{
				int siguiente=col+1;
				while (celdas[fila][siguiente].celdaVacia() && siguiente<this.getTamaño()-1)
				{
					siguiente++;
				}
				if (celdas[fila][col].verificarIgualdad(celdas[fila][siguiente].ObtenerValor())){
					ret=true;
				}
			}	
		}
	return ret;	
	}
	
	private boolean colisionPosibleEnColumna(int col)
	{
		boolean ret=false;
		for (int fila=0; fila<this.getTamaño()-1 && !ret;fila++)
		{
			if (!celdas[fila][col].celdaVacia())
			{
				int siguiente=fila+1;
				while (celdas[siguiente][col].celdaVacia() && siguiente<this.getTamaño()-1)
				{
					siguiente++;
				}
				if (celdas[fila][col].verificarIgualdad(celdas[siguiente][col].ObtenerValor())){
					ret=true;
				}
				
			}
			
		}
		return ret;	
	}
	
	private boolean colisionPosibleHorizontal()
	{
		boolean ret=false;
		for (int fila=0; fila<this.getTamaño()&&!ret;fila++)
		{
			ret=this.colisionPosibleEnFila(fila);
		}
		
		return ret;
	}

	private boolean colisionPosibleVertical()
	{
		boolean ret=false;
		for (int col=0; col<this.getTamaño()&&!ret;col++)
		{
			ret=this.colisionPosibleEnColumna(col);
		}
		return ret;
	}
		
	private boolean posibleColision()
	{
		return (this.colisionPosibleHorizontal()||this.colisionPosibleVertical());
	}
	
	public String sugerirMovimiento()
	{
		Random sug=new Random();
		String[] movimientos={"arriba","abajo","izquierda","derecha"};
		if (posibleColision())
		{
			if (colisionPosibleVertical()&& colisionPosibleHorizontal() )
			{
				return movimientos[sug.nextInt(4)];
			}
			else
			{
				if (colisionPosibleVertical())
				{
					return movimientos[sug.nextInt(2)];
				}
				else
				{
					return movimientos[sug.nextInt(2)+2];
				}
			}
		}
		else
		{
			return "no hay sugerencias";
		}
	}
	
	
	public boolean puedeMover() 
	{
		if (!this.gano && !this.perdio)
		{
			if (this.perdio) System.out.println("perdio1? ");
			this.perdio=(this.contarLugaresVacios()==0 && !posibleColision());
			if (this.perdio) System.out.println("perdio2? tablero332 ");
		}
		return (!this.gano && !this.perdio);
	}
		
	
	public Boolean juegoTerminado() 
	{
		
		if (this.perdio) System.out.println("PERDISTE. el juego esta terminado");
		if (this.gano) System.out.println("GANASTE. el juego esta terminado");
		return(this.perdio || this.gano);
	}
	
	public Celda[][] GetCeldas(){
		return this.celdas;
	}
	
	public int getTamaño() {
		return this.celdas.length;
	}
	

	public Boolean getPerdio() {
		return perdio;
	}

	public void setPerdio(Boolean perdio) {
		this.perdio = perdio;
	}

	public Boolean getGano() {
		return gano;
	}

	public void setGano(Boolean gano) {
		this.gano = gano;
	}

	public int getPuntajes() {
		return puntajes;
	}

	public void setPuntajes(int puntajes) {
		this.puntajes = puntajes;
	}
	
	public int getPuntajePrevio() {
		return puntajePrevio;
	}

	
}
