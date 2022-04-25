package Utilizador;

public abstract class FichaMedica {
	private boolean seguroMedico;
	private String seguradora;
	private String credencial;
	private String tipoSanguineo;
	private float peso;
	private boolean diabete;
	private boolean hipertensao;
	private boolean doencaCronica;
	private String tipoCronico;
	private String outrasDoencas;
	
	// Getters & Setters
	public boolean isSeguroMedico() {
		return seguroMedico;
	}
	public void setSeguroMedico(boolean seguroMedico) {
		this.seguroMedico = seguroMedico;
	}
	public String getSeguradora() {
		return seguradora;
	}
	public void setSeguradora(String seguradora) {
		this.seguradora = seguradora;
	}
	public String getCredencial() {
		return credencial;
	}
	public void setCredencial(String credencial) {
		this.credencial = credencial;
	}
	public String getTipoSanguineo() {
		return tipoSanguineo;
	}
	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public boolean isDiabete() {
		return diabete;
	}
	public void setDiabete(boolean diabete) {
		this.diabete = diabete;
	}
	public boolean isHipertensao() {
		return hipertensao;
	}
	public void setHipertensao(boolean hipertensao) {
		this.hipertensao = hipertensao;
	}
	public boolean isDoencaCronica() {
		return doencaCronica;
	}
	public void setDoencaCronica(boolean doencaCronica) {
		this.doencaCronica = doencaCronica;
	}
	public String getTipoCronico() {
		return tipoCronico;
	}
	public void setTipoCronico(String tipoCronico) {
		this.tipoCronico = tipoCronico;
	}
	public String getOutrasDoencas() {
		return outrasDoencas;
	}
	public void setOutrasDoencas(String outrasDoencas) {
		this.outrasDoencas = outrasDoencas;
	}
	
	
// Metodos
	public void verFichaMedica() {
		if (this.doencaCronica==true) {
			System.out.println("Doenca cronica: "+this.getTipoCronico());
		}
		if (this.isSeguroMedico()==true) {
			System.out.println("Seguro: "+this.seguradora);
		}else {
		System.out.println("Seguro: ---------");
	}
		System.out.println("Credencia: "+this.getCredencial()+"\nTipo Sangueneo: "+this.getTipoSanguineo()+"\nPeso: "+this.getPeso()+
				"Outras Doencas: "+this.getOutrasDoencas()+"\n hipertensao: "+this.isHipertensao()+"\nDiabete: "+this.isDiabete());
		
	}
	
}