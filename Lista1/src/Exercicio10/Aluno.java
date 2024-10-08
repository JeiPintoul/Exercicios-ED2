package Exercicio10;

class Aluno {
    private int matricula;

    public Aluno(int matricula) {
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return String.valueOf(matricula);
    }
}
