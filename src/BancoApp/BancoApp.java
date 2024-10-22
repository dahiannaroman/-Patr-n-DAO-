package BancoApp;

    class SaldoInsuficienteException extends Exception{
        public SaldoInsuficienteException(String message){
            super(message);
        }
    }

    class MontoNegativoException extends Exception {
        public MontoNegativoException(String message){
            super(message);
        }
    }

    class CuentaBancaria {
        private String titular;
        private double saldo;

        public CuentaBancaria(String titular){
            this.titular = titular;
            this.saldo = 0.0;
        }

        public void retirar (double monto) throws SaldoInsuficienteException{
            if (monto > saldo) {
                throw new SaldoInsuficienteException("Saldo insuficiente para retirar " + monto);
            }
            saldo -= monto;
        }

        public void depositar(double monto) throws MontoNegativoException{
            if(monto < 0){
                throw new MontoNegativoException("El monto a depositar no puede ser negativo");
            }
            saldo += monto;
        }

        public void transferir(CuentaBancaria cuentaDestino, double monto) throws SaldoInsuficienteException, MontoNegativoException{
           if(monto < 0) {
               throw new MontoNegativoException("El monto a transferir no puede ser negativo");
           }
           this.retirar(monto);
           cuentaDestino.depositar(monto);
        }

        public double getSaldo(){
            return saldo;
        }

        public String getTitular(){
            return titular;
        }
    }

    public class BancoApp{
        public static void main(String[] args) {
            CuentaBancaria cuenta1 = new CuentaBancaria("Juan");
            CuentaBancaria cuenta2 = new CuentaBancaria("Maria");

            try {
                cuenta1.depositar(500);
                System.out.println("Saldo de Juan: " + cuenta1.getSaldo());

                cuenta1.retirar(200);
                System.out.println("Saldo de Juan después de retirar 200: " + cuenta1.getSaldo());

                cuenta1.transferir(cuenta2, 300);
                System.out.println("Saldo de Juan después de transferir 300: " + cuenta1.getSaldo());
                System.out.println("Saldo de Maria después de recibir 300: " + cuenta2.getSaldo());

                cuenta1.retirar(1000); // Esto lanzará una excepción
            } catch (SaldoInsuficienteException | MontoNegativoException e) {
                System.out.println("Error: " + e.getMessage());

            }
        }
    }

