import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import java.net.*;

public class AddServiceClient {
    public static void main(String[] args) throws Exception {
        Service service = new Service();
        Call call = (Call) service.createCall();
        String endpoint = "http://localhost:8080/AddService.java";
        call.setTargetEndpointAddress(new URL(endpoint));
        call.setOperationName("add");
        int a = 0;
        int b = 0;
        try {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        int sum = (Integer) call.invoke(new Object[]{a, b});
        System.out.println("Sum" + a + " + " + b + " = " + sum);
    }
}