package com.company;

public class Aplikasi {

    public static void caseMenuUtama(int pilihan){
        switch (pilihan){
            case 1 :
                caseMenuProspect(Main.MenuProspect());
                break;
            case 2 :
                caseMenuCustomer(Main.MenuCustomer());
                break;
            case 3 :
                System.exit(0);
                break;
            default:
                System.out.println(" ");
                break;
        }
    }

    public static void caseMenuProspect(int pilihan){
        switch (pilihan){
            case 1 :
                Main.addProspect();
                caseMenuUtama(Main.MainMenu());
                break;
            case 2 :
                Main.ProspectToCustomer();
                System.out.println("Kembali ke menu porspect");
                caseMenuProspect(Main.MenuProspect());
                break;
            case 3 :
                caseMenuUtama(Main.MainMenu());
                break;
            case 4 :
                System.exit(0);
                break;
            default:
                System.out.println(" ");
                break;
        }
    }

    public static void caseMenuCustomer(int pilihan){
        switch (pilihan){
            case 1 :
               Main.BuyProduct();
               caseMenuUtama(Main.MainMenu());
                break;
            case 2 :
                Main.DetailPolicy();
                caseMenuUtama(Main.MainMenu());
                break;
            case 3 :
                caseMenuUtama(Main.MainMenu());
                break;
            case 4 :
                System.exit(0);
                break;
            default:
                System.out.println(" ");
                break;
        }
    }
}
