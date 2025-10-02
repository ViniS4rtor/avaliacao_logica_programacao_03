
public class Reserva {
	// Atributos obrigatórios
	private String nome;
	private String data;
	private String hora;

	public Reserva(String nome, String data, String hora) {
		this.nome = nome;
		this.data = data;
		this.hora = hora;
	}

	// Métodos Getters

	public String getNome() {
		return nome;
	}

	public String getData() {
		return data;
	}

	public String getHora() {
		return hora;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return String.format("Nome: %-20s | Data: %-12s | Hora: %-8s", nome, data, hora);
	}

}
