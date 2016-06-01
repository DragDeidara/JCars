
public class Carro {

	private String Marca;
	private String Modelo;
	private String Cor;
	private int Cilindrada;
	private String Matricula;
	private String Combustivel;
	private String AnoAquisi��o;
	private float Pre�oAquisi��o;

	public Carro(String marca, String modelo, String cor, int cilindrada, String matricula, String combustivel,
			String anoAquisi��o, float pre�oAquisi��o) {
		super();
		Marca = marca;
		Modelo = modelo;
		Cor = cor;
		Cilindrada = cilindrada;
		Matricula = matricula;
		Combustivel = combustivel;
		AnoAquisi��o = anoAquisi��o;
		Pre�oAquisi��o = pre�oAquisi��o;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public String getCor() {
		return Cor;
	}

	public void setCor(String cor) {
		Cor = cor;
	}

	public int getCilindrada() {
		return Cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		Cilindrada = cilindrada;
	}

	public String getMatricula() {
		return Matricula;
	}

	public void setMatricula(String matricula) {
		Matricula = matricula;
	}

	public String getCombustivel() {
		return Combustivel;
	}

	public void setCombustivel(String combustivel) {
		Combustivel = combustivel;
	}

	public String getAnoAquisi��o() {
		return AnoAquisi��o;
	}

	public void setAnoAquisi��o(String anoAquisi��o) {
		AnoAquisi��o = anoAquisi��o;
	}

	public float getPre�oAquisi��o() {
		return Pre�oAquisi��o;
	}

	public void setPre�oAquisi��o(float pre�oAquisi��o) {
		Pre�oAquisi��o = pre�oAquisi��o;
	}




}
