package Persistencia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class FuncoesJPA {
    
    public static EntityManager AbrirTransacao(){        
        EntityManager gerente = FabricaJPA.getManager();
        gerente.getTransaction().begin();
        return gerente;
    }
    
    public static void FecharTransacao(EntityManager gerente, boolean bCommit){
        if (bCommit)
            gerente.getTransaction().commit();
        else
            gerente.getTransaction().rollback();
        
        gerente.close();
    }
       
    public static void Persistir(Object obj){
        EntityManager trans = AbrirTransacao();
	trans.persist(obj);
	FecharTransacao(trans, true);
//        System.out.println("chave após Persistir: " + obj.getId());
    }
    
    public static void Fundir(Object obj){
        EntityManager trans = AbrirTransacao();
	trans.merge(obj);
	FecharTransacao(trans, true);       
//        System.out.println("chave após Fundir: " + obj.getId());
    }
    
    public static void Excluir(int iChave, Class classe){
        EntityManager trans = AbrirTransacao();
	Object obj = trans.find(classe, iChave);
        trans.remove(obj);
	FecharTransacao(trans, true);        
    }
    
    public static Object recuperar(int chave, Class classe){
        EntityManager trans = FabricaJPA.getManager();
        //JOptionPane.showMessageDialog(null, classe.toString());
	return trans.find(classe, chave);
    }    
    
    public static List<?> Selecionar(Class classe, String whereJPQL){
        EntityManager trans = FabricaJPA.getManager();
	String sJPQL = "select u from " + classe.getName() + " u " + whereJPQL;
    //  JOptionPane.showMessageDialog(null, sJPQL);
        Query minhaQuery = trans.createQuery(sJPQL);
        return minhaQuery.getResultList();        
    }       
    
    public static List<Integer> SelecionarCodigos(Class classe, String whereJPQL){
        EntityManager trans = FabricaJPA.getManager();
	String sJPQL = "select u.id from " + classe.getName() + " u " + whereJPQL;
        Query minhaQuery = trans.createQuery(sJPQL);
        return minhaQuery.getResultList();        
    }
    
    public static List<?> Selecionar(Class classe, String[][] parametros){       
	String sWhere = "";
        if (parametros.length > 0) {            
            for (int i = 0; i < parametros.length; i++) {                
                if (i == 0)
                    sWhere = sWhere + " where ";
                else
                    sWhere = sWhere + " and ";
            
                String campo = parametros[i][0];
                String valor = parametros[i][1];
                
                sWhere = sWhere + campo + " = " + valor;                
            }
        }
        return Selecionar(classe, sWhere);
    }
    
    public static List<Integer> SelecionarCodigos(Class classe, String[][] parametros){       
	String sWhere = "";
        if (parametros.length > 0) {            
            for (int i = 0; i < parametros.length; i++) {                
                if (i == 0)
                    sWhere = sWhere + " where ";
                else
                    sWhere = sWhere + " and ";
            
                String campo = parametros[i][0];
                String valor = parametros[i][1];
                
                sWhere = sWhere + campo + " = " + valor;                
            }
        }
        return SelecionarCodigos(classe, sWhere);
    }
    
    public static List<?> RecuperarPorCodigos(Class classe, String[][] parametros){       
	String sWhere = "";
        if (parametros.length > 0) {          
            for (int i = 0; i < parametros.length; i++) {
                String campo = parametros[i][0];
                String valor = parametros[i][1];
            
                if (i == 0)
                    sWhere = sWhere + "where " + campo + " in ( " + valor ;    
                else
                    sWhere = sWhere + "," + valor;               
            }
            sWhere = sWhere + " )";
        }
        return Selecionar(classe, sWhere);
    }
    
    public static List<?> Selecionar(Class classe){
        return Selecionar(classe, "");
    }
    
        
    public static int Count(Class classe){
        EntityManager trans = FabricaJPA.getManager();
        String sJPQL = "select COUNT(c) from " + classe.getName() + " c";
        Query minhaQuery = trans.createQuery(sJPQL);
        return Integer.valueOf(minhaQuery.getSingleResult().toString());    // RETORNA O RESULTADO DO COUNT CONVERTENDO PARA O TIPO INTEIRO
    }
    
    public static List<?> SelecionarEntre(Class classe, int codIni, int codFim){                 

        EntityManager trans = FabricaJPA.getManager();
	String sJPQL = "select u from " + classe.getName() + " u where u.id between " + codIni + " and " + codFim;
        //  JOptionPane.showMessageDialog(null, sJPQL);
        Query minhaQuery = trans.createQuery(sJPQL);
        return minhaQuery.getResultList();  
        
    }
}
