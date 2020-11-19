

import javax.swing.JOptionPane;

public class Teclado {
    public static int leInt (String msg) {
        int i = 0;

        try {
            String temp = JOptionPane.showInputDialog (msg);

            if (temp == null || temp.equals (""))
                return 0;

            i = Integer.parseInt (temp);
        } catch (NumberFormatException e) {
            boolean valorInvalido;

            do {
                valorInvalido = false;
                try {
                    String temp = JOptionPane.showInputDialog ("O valor digitado deve ser"
                            + " um numero inteiro." + "\n" + msg);
                    i = Integer.parseInt (temp);
                } catch (NumberFormatException e2) {
                    valorInvalido = true;
                }
            } while (valorInvalido);
        }

        return i;
    }

    public static int leInt (int valorMinimo, int valorMaximo, String msg) {
        int i = 0;

        try {
            String temp = JOptionPane.showInputDialog (msg);
            i = Integer.parseInt (temp);

            while (i < valorMinimo || i > valorMaximo) {
                temp = JOptionPane.showInputDialog ("O valor digitado deve ser um numero inteiro contido "
                        + "entre " + valorMinimo + " e " + valorMaximo + ".\n" + msg);
                i = Integer.parseInt (temp);
            }
        } catch (NumberFormatException e) {
            boolean valorInvalido;

            do {
                valorInvalido = false;
                try {
                    String temp = JOptionPane.showInputDialog ("O valor digitado deve ser um numero inteiro contido "
                            + "entre " + valorMinimo + " e " + valorMaximo + ".\n" + msg);
                    i = Integer.parseInt (temp);
                } catch (NumberFormatException e2) {
                    valorInvalido = true;
                }
            } while (valorInvalido || i < valorMinimo || i > valorMaximo);
        }

        return i;
    }

    public static double leDouble (String msg) {
        double d = 0;

        try {
            String temp = JOptionPane.showInputDialog (msg);
            d = Double.parseDouble (temp);
        } catch (NumberFormatException e) {
            boolean valorInvalido;

            do {
                valorInvalido = false;
                try {
                    String temp = JOptionPane.showInputDialog ("O valor digitado deve ser"
                            + "um numero real." + "\n" + msg);
                    d = Double.parseDouble (temp);
                } catch (NumberFormatException e2) {
                    valorInvalido = true;
                }
            } while (valorInvalido);
        }

        return d;
    }

    public static double leDouble (double valorMinimo, double valorMaximo, String msg) {
        double d = 0;

        try {
            String temp = JOptionPane.showInputDialog (msg);
            d = Double.parseDouble (temp);

            while (d < valorMinimo || d > valorMaximo) {
                temp = JOptionPane.showInputDialog ("O valor digitado deve ser "
                        + "um numero real contido entre " + valorMinimo + " e " + valorMaximo + ".\n" + msg);
                d = Double.parseDouble (temp);
            }

        } catch (NumberFormatException e) {
            boolean valorInvalido;

            do {
                valorInvalido = false;
                try {
                    String temp = JOptionPane.showInputDialog ("O valor digitado deve ser "
                            + "um numero real contido entre " + valorMinimo + " e " + valorMaximo + ".\n" + msg);
                    d = Double.parseDouble (temp);
                } catch (NumberFormatException e2) {
                    valorInvalido = true;
                }
            } while (valorInvalido || d < valorMinimo || d > valorMaximo);
        }

        return d;
    }

    public static char leChar (String msg) {
        String temp = JOptionPane.showInputDialog (msg);
        char c = temp.charAt (0);

        return c;
    }

    public static char leChar (char[] caracteresValidos, String msg) {
        String temp = JOptionPane.showInputDialog (msg);
        char c = temp.charAt (0);

        while (!verificaCaracter (c, caracteresValidos)) {
            temp = JOptionPane.showInputDialog ("O caracter digitado � inv�lido.\n" + msg);
            c = temp.charAt (0);
        }

        return c;
    }

    public static String leString (String msg) {
        return JOptionPane.showInputDialog (msg);
    }

    public static String leString (String[] stringsValidos, String msg) {
        String s = JOptionPane.showInputDialog (msg);

        while (verificaString (s, stringsValidos))
            s = JOptionPane.showInputDialog ("O conte�do digitado � inv�lido.\n" + msg);

        return s;
    }

    //Sim = 0; N�o = 1; Cancelar = 2;
    public static int mostraJanelaDeConfirmacao (String msg) {
        return JOptionPane.showConfirmDialog (null, msg);
    }

    public static void mostraMensagem (String msg) {
        JOptionPane.showMessageDialog (null, msg);
    }

    private static final boolean verificaCaracter (char caracter, char[] caracteresValidos) {
        for (int i = 0; i < caracteresValidos.length; i++)
            if (caracter == caracteresValidos[i])
                return true;

        return false;
    }

    private static final boolean verificaString (String string, String[] stringsValidos) {
        for (int i = 0; i < stringsValidos.length; i++)
            if (string.equals (stringsValidos[i]))
                return true;

        return false;
    }
}
