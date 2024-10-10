public class CheckConvert {

    public CashModel consultationChange() {
        ConsultaCambio consultaCambio = new ConsultaCambio();
        return consultaCambio.buscaTaxasCambio();  // Chama a API e retorna o CashModel com os dados
    }
}