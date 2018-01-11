import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.NtpV3Packet;
import org.apache.commons.net.ntp.TimeInfo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.rmi.ServerException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

public interface IClock {
    LocalDateTime now() throws IOException;
}

class TimeServerClock implements IClock{

    @Override
    public LocalDateTime now() throws IOException {
        Date serverTime = calculateServerTimeAsDate();
        long millDifferenceInLocalVsServer = calcDiffBetweenServerAndLocalDate(serverTime);

        return  LocalDateTime.now();
    }

     static long calcDiffBetweenServerAndLocalDate(Date serverTime) {
        return System.currentTimeMillis() - serverTime.getTime();
    }



     static Date calculateServerTimeAsDate() throws IOException {
        Properties p = new Properties();
        InputStream is = new FileInputStream("nist.properties");
        p.load(is);

        Enumeration e = p.propertyNames();
        while (e.hasMoreElements()){
            String key = (String) e.nextElement();
            Date serverTime = serverTimeAttempt((String)p.getProperty(key));
            if(serverTime != null){
                return serverTime;
            }
        }

        throw new ServerException("No timeServer responded");
    }

    private static Date serverTimeAttempt(String keyProperty) throws IOException {
        NTPUDPClient timeClient = new NTPUDPClient();
        InetAddress inetAddress = InetAddress.getByName(keyProperty);
        TimeInfo timeInfo = timeClient.getTime(inetAddress);
        NtpV3Packet message = timeInfo.getMessage();
        long serverTime = message.getTransmitTimeStamp().getTime();
        Date time = new Date(serverTime);
        return time;

    }

    public static void main(String[] args) {

    }
}

