class CarroCompacto extends CarroEletrico {

    public CarroCompacto(String id, String marca, String modelo, int anoFabricacao, double capacidadeBateria) {

        super(id, marca, modelo, anoFabricacao, capacidadeBateria, 200);

    }


    @Override

    public double getTempoCarga() {

        return 4; // horas

    }

}