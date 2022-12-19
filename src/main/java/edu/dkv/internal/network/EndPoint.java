package edu.dkv.internal.network;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.net.InetAddress;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE)
public class EndPoint {

    private final InetAddress address;
    private final int port;

    public EndPoint(){
        this.address = null;
        this.port = -1;
    }

    public EndPoint(InetAddress address, int port){
        this.address = address;
        this.port = port;
    }

    public InetAddress getAddress() {
        return address;
    }

    public String getAddressAsString() {
        return Objects.requireNonNull(address).getHostName();
    }

    public int getPort() {
        return port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndPoint endPoint = (EndPoint) o;
        return port == endPoint.port && address.equals(endPoint.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, port);
    }

    @Override
    public String toString() {
        return "EndPoint { " + Objects.requireNonNull(address).getHostName() + ":" + port + " }";
    }
}