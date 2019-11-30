package Util;

import java.util.InputMismatchException;

public class Util {
    public static boolean validar(String CPF) {
        CPF = CPF.replaceAll("\\.", "").replaceAll("-", "");
        char dig10, dig11;
        int sm, i, r, num, peso;
        
        if (CPF.equals("00000000000")
                || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }
        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48);
            }
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }
    /*public void filtrar(String[] txt, int[] coluna) {
        try {
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>((DefaultTableModel) jTable1.getModel());
            if (txt.length == 1) {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + txt[0] + "(i?)", coluna[0]));
            }
            if (txt.length == 2) {
                sorter.setRowFilter(RowFilter.andFilter(Arrays.asList(RowFilter.regexFilter("(?i)" + txt[0] + "(i?)", coluna[0]), RowFilter.regexFilter("(?i)" + txt[1] + "(i?)", coluna[1]))));
            }
            if (txt.length == 3) {
                sorter.setRowFilter(RowFilter.andFilter(Arrays.asList(RowFilter.regexFilter("(?i)" + txt[0] + "(i?)", coluna[0]), RowFilter.regexFilter("(?i)" + txt[1] + "(i?)", coluna[1]),RowFilter.regexFilter("(?i)" + txt[2] + "(i?)", coluna[2]))));
            }
            jTable1.setRowSorter(sorter);
        } catch (Exception e) {
            System.out.println(e);
        }
    }*/
}
