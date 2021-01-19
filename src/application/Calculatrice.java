/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author c
 */
public class Calculatrice {

    private char[] operations={'+','-','*','/'};

    public double operation(String chaine) throws Exception
    {
       //On cherche Ã  savoir de quelle opÃ©ration il s'agit
       //Pas d'opÃ©ration trouvÃ©e
       char operation=' ';
       //Place de l'opÃ©ration
       int indice=-1;
       for(int i=0;(i<operations.length)&&(operation==' ');i++)
        {
            indice=chaine.indexOf(operations[i]);
            if(indice>0)
                operation=operations[i];
        }
       //Si on a pas trouvÃ© d'opÃ©ration valide 
       if(operation==' ')
         throw new Exception("Il n'y a pas d'opérateur valide");
      //On regarde si le premier argument est un nombre
      double op1=0d;
      try
      {
         op1=Double.parseDouble(chaine.substring(0,indice).trim());
       }
       catch(Exception e)
       {
          throw new Exception("Le premier opérateur n'est pas un nombre");
        }
      //On regarde si le premier argument est un nombre
      double op2=0d;
      try
      {
         op2=Double.parseDouble(chaine.substring(indice+1).trim());
       }
       catch(Exception e)
       {
          throw new Exception("Le second opérateur n'est pas un nombre");
        }
        //Selon l'opÃ©ration
        switch(operation)
        {
            case '+' :
               return op1+op2;
            case '-' :
               return op1-op2;
            case '*' :
               return op1*op2;
            case '/' :
               if(Math.abs(op2)<Double.MIN_VALUE)
                  throw new Exception("Division par zéro");
               return op1/op2;
        }
        throw new Exception("Problème inconnu !");
    }
}

