
package Pruebas;

import db.dao.ArtistaDAO;
import db.dao.CancionDAO;
import db.dao.UsuarioDAO;
import db.dao.AdministradorDAO;
import db.dao.CancionArtistaDAO;
import db.dao.CancionListaDAO;
import db.dao.DatosPagoDAO;
import db.dao.ListaReproduccionDAO;
import db.entity.Administrador;
import db.entity.Artista;
import db.entity.Cancion;
import db.entity.CancionArtista;
import db.entity.CancionLista;
import db.entity.DatosPago;
import db.entity.ListaReproduccion;
import db.entity.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.*;
import org.jaudiotagger.tag.*;
import org.jaudiotagger.tag.id3.ID3v11Tag;

public class Pruebas {
    public static void main(String []args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException, FileNotFoundException, IOException, CannotReadException, TagException, ReadOnlyFileException, InvalidAudioFrameException{
        //Agregar Usuarios de los 4 tipos
        Usuario u = new Usuario();
        UsuarioDAO uDAO = new UsuarioDAO();
        String [] emails = {"@hotmail.com", "@gmail.com", "@outlook.es", "@yahoo.com.mx", "@ipn.mx", "@inbox.com", "@gmx.com", "@fastmail.com"};
        int email;
        int tipo;
        int aleatorio;
        File archivo = new File ("Usuarios.txt"); //nombre del archivo donde se guardan los nombres
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);
        Random r = new Random();
        int auxi;
        String name;
        for(int j=0; j<50; j++){
            u.setIdUsuario(getIdUsuario());
            name = br.readLine();
            u.setNombre(name);
            u.setApellido_p(br.readLine());
            u.setApellido_m(br.readLine());
            auxi = r.nextInt(10000);
            u.setUsuario(name.replaceAll("\\s", "")+auxi);
            auxi = r.nextInt(10000);
            u.setContrasenia(name.replaceAll("\\s", "")+auxi);
            tipo = 1+r.nextInt(4);
            u.setTipo(tipo);
            aleatorio = 1+ r.nextInt(1000);
            //System.out.println(aleatorio);
            email = r.nextInt(8);
            u.setEmail(name.replaceAll("\\s", "")+aleatorio+emails[email]);
            uDAO.agregarUsuario(u);            
        }
        
        
        String []Ciudad = {"México, México", "Nueva York, Estados Unidos", "Washington, Estados Unidos", "Sur de Canada", "Puebla México", "Otro", "Guadalajara México", "Madrid, España", "Barcelona, España", "Valladolid España"};
        String []Genero = {"Rock", "Pop", "Country", "Metal", "Symphonic Metal", "Trash Metal", "Salsa", "Cumbia"};
        DatosPagoDAO dpDAO = new DatosPagoDAO();
        AdministradorDAO aDAO = new AdministradorDAO();
        ArtistaDAO arDAO = new ArtistaDAO();
        List<Usuario> Usuarios = uDAO.getUsuarios();
        for(int i=0; i<Usuarios.size(); i++){
            switch (Usuarios.get(i).getTipo()) {
                case 2:
                    int num = 3 + r.nextInt(4);
                    for(int x=0;x<num; x++){
                        int n1 = 1000 + r.nextInt(8999);
                        int n2 = 1000 + r.nextInt(8999);
                        int n3 = 1000 + r.nextInt(8999);
                        int n4 = 1000 + r.nextInt(8999);
                        int anio = 2010 + r.nextInt(40);
                        int mes = 1 + r.nextInt(12);
                        int dia = 1+r.nextInt(28);
                        String fecha = anio+"-"+mes+"-"+dia;
                        String tnum = n1+""+n2+""+n3+""+n4;
                        DatosPago dp = new DatosPago(getIdDatosPago(), br.readLine(), br.readLine(), br.readLine(), tnum, fecha, Usuarios.get(i).getIdUsuario());
                        dpDAO.agregarDatosPago(dp);
                    }
                    break;
                case 3:
                    int codigo = 100 +r.nextInt(10000);
                    Administrador Ad=new Administrador(getIdAdministrador(), codigo+"", Usuarios.get(i).getIdUsuario());  
                    aDAO.agregarAdministrador(Ad);
                    break;
                case 4:
                    int ciudad = r.nextInt(11);
                    int genero = r.nextInt(8);
                    String desc = "Nació en la ciudad de "+Ciudad[ciudad]+". Mejor conocido por tocar el genero de "+Genero[genero];
                    Artista ar = new Artista(getIdArtista(), desc, Usuarios.get(i).getIdUsuario());
                    arDAO.agregarArtista(ar);
                    break;
                default:
                    break;
            }
        }
        
        
        //Agregar Canciones
        AudioFile audiofile; 
        Tag tag;
        File f = new File("Canciones"); //nombre de la carpeta
        File[] canciones = f.listFiles();
        Cancion c;
        CancionDAO cDAO = new CancionDAO();
        for(int i=0; i<canciones.length; i++){
            if(canciones[i].getName().contains(".mp3")){
                audiofile = AudioFileIO.read(canciones[i]);
                tag = audiofile.getTag();
                //System.out.println(tag.getFirst(FieldKey.TITLE)+" "+tag.getFirst(FieldKey.YEAR));
                int id = getIdCancion();
                c = new Cancion(id, tag.getFirst(FieldKey.TITLE), tag.getFirst(FieldKey.ALBUM), tag.getFirst(FieldKey.GENRE), 0, Integer.parseInt(tag.getFirst(FieldKey.YEAR)));
                cDAO.agregarCancion(c);
                File nuevo = new File("Canciones/"+id+".mp3");
                canciones[i].renameTo(nuevo);
            }
            //System.out.println(canciones[i].getName());
        }
    }
    public static int getIdUsuario() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UsuarioDAO uDAO = new UsuarioDAO();
        List usuarios = uDAO.getUsuarios();
        int id = usuarios.size() + 1;
        while (true) {
            Usuario aux = uDAO.buscarUsuario(id);
            if (aux == null) {
                break;
            } else {
                id++;
            }
        }
        return id;
    }

    public static int getIdArtista() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        ArtistaDAO uDAO = new ArtistaDAO();
        List usuarios = uDAO.getArtistas();
        int id = usuarios.size() + 1;
        while (true) {
            Artista aux = uDAO.buscarArtista(id);
            if (aux == null) {
                break;
            } else {
                id++;
            }
        }
        return id;
    }

    public static int getIdCancion() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        CancionDAO uDAO = new CancionDAO();
        List canciones = uDAO.getCanciones();
        int id = canciones.size() + 1;
        while (true) {
            Cancion aux = uDAO.buscarCancion1(id);
            if (aux == null) {
                break;
            } else {
                id++;
            }
        }
        return id;
    }
    public static int getIdDatosPago() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        DatosPagoDAO uDAO = new DatosPagoDAO();
        List datosapago = uDAO.getDatosPagos();
        int id = datosapago.size() + 1;
        while (true) {
            DatosPago aux = uDAO.buscardatosPago(id);
            if (aux == null) {
                break;
            } else {
                id++;
            }
        }
        return id;
    }
    public static int getIdListaReproduccion() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        ListaReproduccionDAO lDAO = new ListaReproduccionDAO();
        List ListaReproducciones = lDAO.getListasReproduccion();
        int id = ListaReproducciones.size() + 1;
        while (true) {
            ListaReproduccion aux = lDAO.buscarLista1(id);
            if (aux == null) {
                break;
            } else {
                id++;
            }
        }
        return id;
    }
    
    public static int getIdAdministrador() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        AdministradorDAO aDAO = new AdministradorDAO();
        List admins = aDAO.getAdministradores();
        //ListaReproduccionDAO lDAO = new ListaReproduccionDAO();
        //List ListaReproducciones = lDAO.getListasReproduccion();
        int id = admins.size() + 1;
        while (true) {
            Administrador aux = aDAO.buscarAdministrador(id);
            if (aux == null) {
                break;
            } else {
                id++;
            }
        }
        return id;
    }
    

}
