package dan.ms.tp.msusuarios.rest;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("api/health")
public class HealthController {
    
    @CrossOrigin(origins = "http://localhost:9400") // Permitir solicitudes desde localhost:9400
    @GetMapping
    public ResponseEntity<Map<String,String>> health(HttpServletRequest request){
        // Get the server name
        Map<String,String> res = new LinkedHashMap<>();
        res.put("serverName",request.getServerName());
        res.put("app","ms-usuarios");
        res.put("status","OK");
        res.put("timestamp",Instant.now().toString());
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            res.put("serverIp",localhost.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace(); // Handle the exception appropriately in your code
        }
        return ResponseEntity.ok().body(res);
    }
}
