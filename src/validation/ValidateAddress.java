package validation;



import com.smartystreets.api.ClientBuilder;
import com.smartystreets.api.StaticCredentials;
import com.smartystreets.api.exceptions.SmartyException;
import com.smartystreets.api.us_street.Candidate;
import com.smartystreets.api.us_street.Client;
import com.smartystreets.api.us_street.Lookup;

import java.io.IOException;
import java.util.ArrayList;

public class ValidateAddress {



    public boolean Validate_Adress(String address, String city, String zip) {
        if(city.equalsIgnoreCase("NONE") || address.isEmpty() || zip.isEmpty()){
            return false;
        }
        String authId = "2c024a83-a3a4-2cb4-ec9b-eca5e023bfb4";
        String authToken = "qJBIEA38a0wvWBcOiZs3";

        StaticCredentials credentials = new StaticCredentials(authId, authToken);
        Client client = new ClientBuilder(credentials).buildUsStreetApiClient();
        Lookup lookup = new Lookup();

        lookup.setCity(city);
        lookup.setStreet(address);
        lookup.setState("NY");
        lookup.setZipCode(zip);

        try {
            client.send(lookup);


        } catch (SmartyException ex) {

            System.out.println(ex.getMessage());
           ex.printStackTrace();
            return false;

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        ArrayList<Candidate> results = lookup.getResult();
        Candidate firstCandidate = results.get(0);

        if (results.isEmpty()) {
            System.out.println("No candidates. This means the address is not valid.");
            return false;

        }else if (!firstCandidate.getComponents().getZipCode().equalsIgnoreCase(zip)) {
            return false;
        }else {
            System.out.println("Address is valid. (There is at least one candidate)\n");
            System.out.println("ZIP Code: " + firstCandidate.getComponents().getZipCode());
            System.out.println("County: " + firstCandidate.getMetadata().getCountyName());

            return true;
        }

    }

    public boolean test(){
        // We recommend storing your secret keys in environment variables instead---it's safer!
        String authId =  "2c024a83-a3a4-2cb4-ec9b-eca5e023bfb4";
        String authToken = "qJBIEA38a0wvWBcOiZs3";

        StaticCredentials credentials = new StaticCredentials(authId, authToken);
        Client client = new ClientBuilder(credentials).buildUsStreetApiClient();

        Lookup lookup = new Lookup();
        lookup.setStreet("1600 Amphitheatre Pkwy");
        lookup.setCity("Mountain View");
        lookup.setState("CA");

        try {
            client.send(lookup);
        }
        catch (SmartyException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        ArrayList<Candidate> results = lookup.getResult();

        if (results.isEmpty()) {
            System.out.println("No candidates. This means the address is not valid.");
            return false;
        }

        Candidate firstCandidate = results.get(0);

        System.out.println("Address is valid. (There is at least one candidate)\n");
        System.out.println("ZIP Code: " + firstCandidate.getComponents().getZipCode());
        System.out.println("County: " + firstCandidate.getMetadata().getCountyName());
        System.out.println("Latitude: " + firstCandidate.getMetadata().getLatitude());
        System.out.println("Longitude: " + firstCandidate.getMetadata().getLongitude());
        return true;

    }


}
