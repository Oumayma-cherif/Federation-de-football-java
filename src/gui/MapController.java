/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import com.teamdev.jxmaps.GeocoderCallback;
import com.teamdev.jxmaps.GeocoderRequest;
import com.teamdev.jxmaps.GeocoderResult;
import com.teamdev.jxmaps.GeocoderStatus;
import com.teamdev.jxmaps.InfoWindow;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapReadyHandler;
import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.MapViewOptions;
import com.teamdev.jxmaps.Marker;
import com.teamdev.jxmaps.javafx.MapView;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahmed.A.Hsouna
 */
public class MapController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
    }    
    
    public void init() throws Exception {
        MapView.InitJavaFX();
    }

    public void start(final Stage primaryStage) {
        MapViewOptions options = new MapViewOptions();
        options.importPlaces();
        options.setApiKey("<your_google_maps_api_key>");
        final MapView mapView = new MapView(options);

        mapView.setOnMapReadyHandler(new MapReadyHandler() {
            @Override
            public void onMapReady(MapStatus status) {
                if (status == MapStatus.MAP_STATUS_OK) {
                    final Map map = mapView.getMap();
                    map.setZoom(5.0);
                    GeocoderRequest request = new GeocoderRequest();
                    request.setAddress("Kharkiv, UA");

                    mapView.getServices().getGeocoder().geocode(request, new GeocoderCallback(map) {
                        @Override
                        public void onComplete(GeocoderResult[] result, GeocoderStatus status) {
                            if (status == GeocoderStatus.OK) {
                                map.setCenter(result[0].getGeometry().getLocation());
                                Marker marker = new Marker(map);
                                marker.setPosition(result[0].getGeometry().getLocation());

                                final InfoWindow window = new InfoWindow(map);
                                window.setContent("Hello, World!");
                                window.open(map, marker);
                            }
                        }
                    });
                }
            }
        });

        Scene scene = new Scene(new BorderPane(mapView), 700, 500);
        primaryStage.setTitle("JxMaps - Hello, World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
