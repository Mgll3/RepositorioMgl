
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    /* todo
    - frases motivadoras
    - Crear pantalla final, y de la pantalla final halla boton jugar de nuevo  y mande para elegir modo o realmente cerrarse
    -
    -crear clases                                               Hecho
    -metodos                                                    Hecho
    -programacion de tiempo, tiempo acumulado etc               Hecho
    -buscar preguntas                                           Hecho
    -crear pantalla de elegir modo de juego                     Hecho
    -crear la pantalla donde se muestra las preguntas           Hecho
    -crear la pantalla de preguntas con dos jugadores           Hecho
    -Reglas del negocio                                         Hecho
    -parte visual o grafica                                     Hecho
    -Programar lógica del comodín                               Hecho
    -programar lógica de fin de preguntas y mezcla de tópicos   Hecho
     */

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/inicio.fxml"));
        primaryStage.setTitle("Inicio");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();

    }






}
