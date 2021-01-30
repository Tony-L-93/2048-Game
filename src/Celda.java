import java.util.Random;
//lalala
public class Celda {
	private Boolean choque;
	private int valor;
	
	public Celda(int valor) {
		this.valor=valor;
		this.choque = false;
	}
	
	public void asignarValorRandom() {
		Random valorRandom= new Random();
		if(valorRandom.nextInt(4)==3)
			this.valor= 4;
		else
			this.valor=2;
	}
	
	public int ObtenerValor() {
		return this.valor;
	}
	
	public Boolean celdaVacia(){
		if(this.valor==0)
			return true;
		return false;	
	}
	
	public boolean getCollision() {
		return this.choque;
	}
	
	public void Collision(Boolean validacion) {
		this.choque = validacion;
	}
	
	public void sumarValor() {
		this.valor *= 2;
	}
	
	public void AsignarValor(int valor) {
		this.valor=valor;
	}
	
	public boolean verificarIgualdad(int valor)
	{
		return this.valor == valor ? true : false;
	}
	public String toString()
	{
		return String.valueOf(this.ObtenerValor());
	}
}
