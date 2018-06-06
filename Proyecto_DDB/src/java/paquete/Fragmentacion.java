package paquete;

import db.dao.*;
import db.entity.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alfredo
 */
public class Fragmentacion extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String opcion = request.getParameter("op");
        //HttpSession session = request.getSession();
        int op = Integer.parseInt(opcion);
        int relacion;
        String atributo, operador, valor;
        String atributo_1, operador_1, valor_1, atributo_2, operador_2, valor_2;
        int respuesta = 0;
        switch (op) {
            //comprobacion predicados simples
            case 1:
                relacion = Integer.parseInt(request.getParameter("relacion"));
                atributo = request.getParameter("atributo");
                operador = request.getParameter("operador");
                valor = request.getParameter("valor");
                try {
                    respuesta = comprobarPredicadosSimples(relacion, atributo, operador, valor);
                } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(Fragmentacion.class.getName()).log(Level.SEVERE, null, ex);
                }
                out.print(respuesta);
                return;
            case 2:
                relacion = Integer.parseInt(request.getParameter("relacion"));
                atributo_1 = request.getParameter("atributo_1");
                operador_1 = request.getParameter("operador_1");
                valor_1 = request.getParameter("valor_1");
                atributo_2 = request.getParameter("atributo_2");
                operador_2 = request.getParameter("operador_2");
                valor_2 = request.getParameter("valor_2");
                System.out.println(relacion+" "+atributo_1+" "+operador_1+" "+valor_1+" "+atributo_2+" "+operador_2+" "+valor_2);
                try {
                    respuesta = comprobarPredicadosMiniterminos(relacion, atributo_1, operador_1, valor_1, atributo_2, operador_2, valor_2);
                } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(Fragmentacion.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.print("\n\n\nRespuesta: "+respuesta+"\n\n\n\n");
                out.print(respuesta);
                return;
            case 3:
                relacion = Integer.parseInt(request.getParameter("relacion"));
                atributo_1 = request.getParameter("atributo_1");
                operador_1 = request.getParameter("operador_1");
                valor_1 = request.getParameter("valor_1");
                atributo_2 = request.getParameter("atributo_2");
                operador_2 = request.getParameter("operador_2");
                valor_2 = request.getParameter("valor_2");
                int sitio_n = Integer.parseInt(request.getParameter("sitio"));
                String sitio="", nombreBase="", contrasenia ="";
                System.out.println("Caso 3 relacion: "+relacion+" atributo_1: "+atributo_1+" operador_1: "+operador_1+" valor_1: "+valor_1+" atributo_2: "+atributo_2+" operador_2: "+operador_2+" valor_2: "+valor_2 );
                switch(sitio_n){
                    case 1:
                        sitio = "jdbc:mysql://localhost/";
                        nombreBase = "proyecto_ddb_1";
                        contrasenia = "root";
                        break;
                    case 2:
                        sitio = "jdbc:mysql://10.100.76.213/";
                        nombreBase = "proyDB";
                        contrasenia = "raizserver@Mario";
                        break;
                    case 3:
                        sitio = "jdbc:mysql://10.100.74.82/";
                        nombreBase = "proyecto_ddb";
                        contrasenia = "brenda2117100296";
                        break;
                }
                //String nombreBase = request.getParameter("nombreBase");
                try {
                    guardarPredicadosMiniterminos(relacion, atributo_1, operador_1, valor_1, atributo_2, operador_2, valor_2, sitio, nombreBase, contrasenia);
                } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(Fragmentacion.class.getName()).log(Level.SEVERE, null, ex);
                }
                out.print(1);
                return;
                
            //comprobacion predicados miniterminos
            //insercion del la fragmentacion vertical
            case 4:
                String relacion2 = request.getParameter("relacion");
                atributo_1 = request.getParameter("predicado");
                int sitio_n2 = Integer.parseInt(request.getParameter("sitio"));
                String sitio2="", nombreBase2="", contrasenia2 ="";
                System.out.println("Caso 4 predicado: "+atributo_1);
                switch(sitio_n2){
                    case 1:
                        sitio2 = "jdbc:mysql://localhost/proyecto_ddb";
                        nombreBase2 = "proyecto_ddb_1";
                        contrasenia2 = "root";
                        break;
                    case 2:
                        sitio2 = "jdbc:mysql://192.168.1.70/prueba";
                        nombreBase2 = "proyDB";
                        contrasenia2 = "root";
                        break;
                    case 3:
                        sitio2 = "jdbc:mysql://10.100.74.82/";
                        nombreBase2 = "proyecto_ddb";
                        contrasenia2 = "brenda2117100296";
                        break;
                }
                //String nombreBase = request.getParameter("nombreBase");
                try {
                    guardarPredicadosMiniterminos2(atributo_1,relacion2,sitio2, nombreBase2, contrasenia2);
                } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(Fragmentacion.class.getName()).log(Level.SEVERE, null, ex);
                }
                out.print(1);
                return;

        }

    }

    public int comprobarPredicadosSimples(int relacion, String atributo, String operador, String valor) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        AdministradorDAO adao = new AdministradorDAO();
        ArtistaDAO ardao = new ArtistaDAO();
        CancionArtistaDAO cadao = new CancionArtistaDAO();
        CancionDAO cdao = new CancionDAO();
        CancionListaDAO cldao = new CancionListaDAO();
        DatosPagoDAO dpdao = new DatosPagoDAO();
        ListaReproduccionDAO lrdao = new ListaReproduccionDAO();
        UsuarioDAO udao = new UsuarioDAO();
        int num = 0;
        switch (relacion) {
            case 1:
                num = adao.count(atributo, operador, valor);
                break;
            case 2:
                num = ardao.count(atributo, operador, valor);
                break;
            case 3:
                num = cdao.count(atributo, operador, valor);
                break;
            case 4:
                num = cadao.count(atributo, operador, valor);
                break;
            case 5:
                num = dpdao.count(atributo, operador, valor);
                break;
            case 6:
                num = lrdao.count(atributo, operador, valor);
                break;
            case 7:
                num = udao.count(atributo, operador, valor);
                break;
            case 8:
                num = cldao.count(atributo, operador, valor);
                break;
        }
        if (num > 0) {
            return 1;
        }
        return 0;
    }

    public int comprobarPredicadosMiniterminos(int relacion, String atributo_1, String operador_1, String valor_1, String atributo_2, String operador_2, String valor_2) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        AdministradorDAO adao = new AdministradorDAO();
        ArtistaDAO ardao = new ArtistaDAO();
        CancionArtistaDAO cadao = new CancionArtistaDAO();
        CancionDAO cdao = new CancionDAO();
        CancionListaDAO cldao = new CancionListaDAO();
        DatosPagoDAO dpdao = new DatosPagoDAO();
        ListaReproduccionDAO lrdao = new ListaReproduccionDAO();
        UsuarioDAO udao = new UsuarioDAO();
        int num = 0;
        switch (relacion) {
            case 1:
                num = adao.count2(atributo_1, operador_1, valor_1, atributo_2, operador_2, valor_2);
                break;
            case 2:
                num = ardao.count2(atributo_1, operador_1, valor_1, atributo_2, operador_2, valor_2);
                break;
            case 3:
                num = cdao.count2(atributo_1, operador_1, valor_1, atributo_2, operador_2, valor_2);
                break;
            case 4:
                num = cadao.count2(atributo_1, operador_1, valor_1, atributo_2, operador_2, valor_2);
                break;
            case 5:
                num = dpdao.count2(atributo_1, operador_1, valor_1, atributo_2, operador_2, valor_2);
                break;
            case 6:
                num = lrdao.count2(atributo_1, operador_1, valor_1, atributo_2, operador_2, valor_2);
                break;
            case 7:
                num = udao.count2(atributo_1, operador_1, valor_1, atributo_2, operador_2, valor_2);
                break;
            case 8:
                num = cldao.count2(atributo_1, operador_1, valor_1, atributo_2, operador_2, valor_2);
                break;
        }
        if (num > 0) {
            return 1;
        }
        return 0;
    }

    public void guardarPredicadosMiniterminos(int relacion, String atributo_1, String operador_1, String valor_1, String atributo_2, String operador_2, String valor_2, String sitio, String nombreBase, String contrasenia) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        AdministradorDAO adao = new AdministradorDAO();
        ArtistaDAO ardao = new ArtistaDAO();
        CancionArtistaDAO cadao = new CancionArtistaDAO();
        CancionDAO cdao = new CancionDAO();
        CancionListaDAO cldao = new CancionListaDAO();
        DatosPagoDAO dpdao = new DatosPagoDAO();
        ListaReproduccionDAO lrdao = new ListaReproduccionDAO();
        UsuarioDAO udao = new UsuarioDAO();
        
        //int num = 0;
        switch (relacion) {
            case 1:
                List<Administrador> admins = adao.getTuplas(atributo_1, operador_1, valor_1, atributo_2, operador_2, valor_2);
                for(int i=0; i<admins.size(); i++){
                    adao.agregarAdministradorSitio(admins.get(i), sitio, nombreBase, contrasenia);
                }
                break;
            case 2:
                List<Artista> artists = ardao.getTuplas(atributo_1, operador_1, valor_1, atributo_2, operador_2, valor_2);
                for(int i=0; i<artists.size(); i++){
                    ardao.agregarArtistaSitio(artists.get(i), sitio, nombreBase, contrasenia);
                }
                break;
            case 3:
                List<Cancion> canciones = cdao.getTuplas(atributo_1, operador_1, valor_1, atributo_2, operador_2, valor_2);
                for(int i=0; i<canciones.size(); i++){
                    cdao.agregarCancionSitio(canciones.get(i), sitio, nombreBase, contrasenia);
                }
                break;
            case 4:
                List<CancionArtista> cas = cadao.getTuplas(atributo_1, operador_1, valor_1, atributo_2, operador_2, valor_2);;
                for(int i=0; i<cas.size(); i++){
                    cadao.agregarCancionArtistaSitio(cas.get(i), sitio, nombreBase, contrasenia);
                }
                break;
            case 5:
                List<DatosPago> dps  = dpdao.getTuplas(atributo_1, operador_1, valor_1, atributo_2, operador_2, valor_2);
                for(int i=0; i<dps.size(); i++){
                    dpdao.agregarDatosPagoSitio(dps.get(i), sitio, nombreBase, contrasenia);
                }
                break;
            case 6:
                List<ListaReproduccion> lrs = lrdao.getTuplas(atributo_1, operador_1, valor_1, atributo_2, operador_2, valor_2);
                for(int i=0; i<lrs.size(); i++){
                    lrdao.agregarListaDeReprodccionSitio(lrs.get(i), sitio, nombreBase, contrasenia);
                }
                break;
            case 7:
                List<Usuario> us = udao.getTuplas(atributo_1, operador_1, valor_1, atributo_2, operador_2, valor_2);
                for(int i=0; i<us.size(); i++){
                    udao.agregarUsuarioSitio(us.get(i), sitio, nombreBase, contrasenia);
                }
                break;
            case 8:
                List<CancionLista> cls = cldao.getTuplas(atributo_1, operador_1, valor_1, atributo_2, operador_2, valor_2);
                for(int i=0; i<cls.size(); i++){
                    cldao.agregarCancionEnListaSitio(cls.get(i), sitio, nombreBase, contrasenia);
                }
                break;
        }

    }
    public void guardarPredicadosMiniterminos2(String atributo_1,String relacion2, String sitio_n2, String nombreBase2, String contrasenia2) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String Realacion1 = relacion2+"11";
        System.out.println(atributo_1+","+Realacion1+","+sitio_n2+","+nombreBase2+","+contrasenia2);
        Connection conn = null;       
        Statement stmt = null;
        String aux = null;
        System.out.println(atributo_1);
        String atributos[]=atributo_1.split(",");
        System.out.println("length:"+ atributos.length);
        
        AdministradorDAO adao = new AdministradorDAO();
        ArtistaDAO ardao = new ArtistaDAO();
        CancionArtistaDAO cadao = new CancionArtistaDAO();
        CancionDAO cdao = new CancionDAO();
        CancionListaDAO cldao = new CancionListaDAO();
        DatosPagoDAO dpdao = new DatosPagoDAO();
        ListaReproduccionDAO lrdao = new ListaReproduccionDAO();
        UsuarioDAO udao = new UsuarioDAO();
        
        /* List<Administrador> admins = adao.getVertical(atributo_1,relacion2);
        System.out.println("obenidos correctamente");*/
        switch (atributos[0]) {
            case "idAdministrador":
                switch (atributos.length) {
                    case 1:
                        aux = atributos[0]+" INTEGER not NULL";
                        break;
                    case 2:
                        if(atributos[1].equals("Codigo")){
                            aux = atributos[0]+" INTEGER not NULL, "+atributos[1]+" VARCHAR(10)";
                        }else{
                            aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" INTEGER";
                        }
                        break;
                    case 3:
                        aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(10),"+atributos[2]+" INTEGER";
                        break;
                    
                }
                break;
            case "idArtista":
                switch (atributos.length) {
                    case 1:
                         aux = atributos[0]+" INTEGER not NULL";
                        break;
                    case 2:
                        if(atributos[1].equals("Descripcion")){
                            aux = atributos[0]+" INTEGER not NULL, "+atributos[1]+" VARCHAR(1000)";
                        }else{
                            aux = atributos[0]+" INTEGER not NULL, "+atributos[1]+" INTEGER";
                        }
                            
                        break;
                    case 3:
                        aux = atributos[0]+" INTEGER not NULL, "+atributos[1]+" VARCHAR(1000)"+atributos[1]+" INTEGER";
                        break;
                }
                break;
            case "idCancion":
                switch (atributos.length) {
                    case 1:
                         aux = atributos[0]+" INTEGER not NULL";
                        break;
                    case 2:
                        switch (atributos[1]) {
                            case "Nombre":
                                aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100)";
                                break;
                            case "Album":
                                aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100)";
                                break;
                            case "Genero":
                                aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100)";
                                break;
                            case "No_reproducciones":
                                aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" INTEGER)";
                                break;
                            case "Año":
                                aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" INTEGER)";
                                break;
                           
                        }
                        break;
                    case 3:
                        switch (atributos[1]) {
                            case "Nombre":
                                switch (atributos[2]) {
                                    case "Album":
                                        aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100)";
                                        break;
                                    case "Genero":
                                        aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100)";
                                        break;
                                    case "No_reproducciones":
                                        aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" INTEGER";
                                        break;
                                    case "Año":
                                        aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" INTEGER";
                                        break;                                    
                                }
                                break;
                        }
                        break;
                    case 4:
                        switch (atributos[1]) {
                            case "Nombre":
                                switch (atributos[2]) {
                                    case "Album":
                                        switch (atributos[3]) {
                                            case "Genero":
                                                aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" VARCHAR(100)";
                                                break;
                                            case "No_reproducciones":
                                                aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" INTEGER";
                                                break;
                                            case "Año":
                                                aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" INTEGER";
                                                break;
                                        }
                                        break;
                                    case "Genero":
                                        switch (atributos[3]) {
                                            case "Album":
                                                aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" VARCHAR(100)";
                                                break;
                                            case "No_reproducciones":
                                                aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" INTEGER";
                                                break;
                                            case "Año":
                                                aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" INTEGER";
                                                break;
                                        }
                                        break;
                                    case "No_reproducciones":
                                        switch (atributos[3]) {
                                            case "Album":
                                                aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" VARCHAR(100)";
                                                break;
                                            case "Genero":
                                                aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" VARCHAR(100)";
                                                break;
                                            case "Año":
                                                aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" INTEGER";
                                                break;
                                        }
                                        break;
                                    case "Año":
                                        switch (atributos[3]) {
                                            case "Album":
                                                aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" VARCHAR(100)";
                                                break;
                                            case "Genero":
                                                aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" VARCHAR(100)";
                                                break;
                                            case "No_reproducciones ":
                                                aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" INTEGER";
                                                break;
                                        }
                                        
                                        break;                                    
                                }
                                break;
                        }
                        break;
                    case 5:
                        switch (atributos[1]) {
                            case "Nombre":
                                switch (atributos[2]) {
                                    case "Album":
                                        switch (atributos[3]) {
                                            case "Genero":
                                                if(atributos[4].equals("No_reproducciones")){
                                                    aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" VARCHAR(100),"+atributos[4]+" INTEGER";
                                                }else{
                                                    aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" VARCHAR(100),"+atributos[4]+" INTEGER";
                                                }                                                
                                                break;
                                            case "No_reproducciones":
                                                if(atributos[4].equals("Genero")){
                                                   aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" VARCHAR(100),"+atributos[4]+" INTEGER";
                                                }else{
                                                    aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" VARCHAR(100),"+atributos[4]+" INTEGER";
                                                }
                                                break;
                                            case "Año":
                                                if(atributos[4].equals("Genero")){
                                                    aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" VARCHAR(100),"+atributos[4]+" INTEGER";
                                                }else{
                                                    aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" VARCHAR(100),"+atributos[4]+" INTEGER";
                                                }                                                
                                                break;
                                        }
                                        break;
                                    case "Genero":
                                        switch (atributos[3]) {
                                            case "Album":
                                                 if(atributos[4].equals("No_reproducciones")){
                                                     aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" VARCHAR(100),"+atributos[4]+" INTEGER";
                                                 }else{
                                                     aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" VARCHAR(100),"+atributos[4]+" INTEGER";
                                                 }
                                                break;
                                            case "No_reproducciones":
                                                if(atributos[4].equals("Album ")){
                                                     aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" VARCHAR(100),"+atributos[4]+" INTEGER";
                                                 }else{
                                                     aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" VARCHAR(100),"+atributos[4]+" INTEGER";
                                                 }
                                                break;
                                            case "Año":
                                                if(atributos[4].equals("Album ")){
                                                     aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" VARCHAR(100),"+atributos[4]+" INTEGER";
                                                 }else{
                                                     aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" INTEGER,"+atributos[4]+" INTEGER";
                                                 }
                                                break;
                                        }
                                        break;
                                    case "No_reproducciones":
                                        switch (atributos[3]) {
                                            case "Album":
                                                if(atributos[4].equals("No_reproducciones")){
                                                     aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" VARCHAR(100),"+atributos[4]+" INTEGER";
                                                 }else{
                                                     aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" VARCHAR(100),"+atributos[4]+" INTEGER";
                                                 }
                                                break;
                                            case "Genero":
                                                if(atributos[4].equals("Album")){
                                                     aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" VARCHAR(100),"+atributos[4]+" INTEGER";
                                                 }else{
                                                     aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" VARCHAR(100),"+atributos[4]+" INTEGER";
                                                 }
                                                break;
                                            case "Año":
                                                if(atributos[4].equals("Album")){
                                                     aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" VARCHAR(100),"+atributos[4]+" INTEGER";
                                                 }else{
                                                     aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" INTEGER,"+atributos[4]+" INTEGER";
                                                 }
                                                break;
                                        }
                                        break;
                                    case "Año":
                                        switch (atributos[3]) {
                                            case "Album":
                                                if(atributos[4].equals("Genero")){
                                                     aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" VARCHAR(100),"+atributos[4]+" INTEGER";
                                                 }else{
                                                     aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" INTEGER,"+atributos[4]+" INTEGER";
                                                 }
                                                break;
                                            case "Genero":
                                                if(atributos[4].equals("Album ")){
                                                     aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" VARCHAR(100),"+atributos[4]+" INTEGER";
                                                 }else{
                                                     aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" INTEGER,"+atributos[4]+" INTEGER";
                                                 }
                                                
                                                break;
                                            case "No_reproducciones ":
                                                if(atributos[4].equals("Album ")){
                                                     aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" INTEGER,"+atributos[4]+" INTEGER";
                                                 }else{
                                                     aux = atributos[0]+" INTEGER not NULL,"+atributos[1]+" VARCHAR(100),"+atributos[2]+" VARCHAR(100),"+atributos[3]+" INTEGER,"+atributos[4]+" INTEGER";
                                                 }
                                                break;
                                        }
                                        
                                        break;                                    
                                }
                                break;
                        }
                        break;
                    case 6:
                        break;
                }
                break;
            case "idDatos":
                break;
            case "idLista":
                break;
            case "idUsuario":
                break;
            default:
                break;
        }
       

        System.out.println(aux);
        
       
           
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(sitio_n2, "root", contrasenia2);            
            System.out.println("Connected database successfully...");
            stmt = conn.createStatement();
            
            String sql ="CREATE TABLE "+Realacion1+""+
                        "("+aux+");";
            stmt.executeUpdate(sql);
            
            System.out.println("Created table in given database...");
            
                            
                                    
                            
                    
        }catch(SQLException e){
            e.printStackTrace();
        }
        
            
    }
}
