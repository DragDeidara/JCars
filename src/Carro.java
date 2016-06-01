
public class Carro {

	private String Marca;
	private String Modelo;
	private String Cor;
	private int Cilindrada;
	private String Matricula;
	private String Combustivel;
	private String AnoAquisição;
	private float PreçoAquisição;

	public Carro(String marca, String modelo, String cor, int cilindrada, String matricula, String combustivel,
			String anoAquisição, float preçoAquisição) {
		super();
		Marca = marca;
		Modelo = modelo;
		Cor = cor;
		Cilindrada = cilindrada;
		Matricula = matricula;
		Combustivel = combustivel;
		AnoAquisição = anoAquisição;
		PreçoAquisição = preçoAquisição;
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

	public String getAnoAquisição() {
		return AnoAquisição;
	}

	public void setAnoAquisição(String anoAquisição) {
		AnoAquisição = anoAquisição;
	}

	public float getPreçoAquisição() {
		return PreçoAquisição;
	}

	public void setPreçoAquisição(float preçoAquisição) {
		PreçoAquisição = preçoAquisição;
	}




}
