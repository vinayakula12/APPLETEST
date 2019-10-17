package mytestapple.myapple.model;

public class Cars {
String make;
public String getMake() {
	return make;
}
public void setMake(String make) {
	this.make = make;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public String getVin() {
	return vin;
}
public void setVin(String vin) {
	this.vin = vin;
}
public Metadata getMetadata() {
	return metadata;
}
public void setMetadata(Metadata metadata) {
	this.metadata = metadata;
}
public Perdayrent getPerdayrent() {
	return perdayrent;
}
public void setPerdayrent(Perdayrent perdayrent) {
	this.perdayrent = perdayrent;
}
public Metrics getMetrics() {
	return metrics;
}
public void setMetrics(Metrics metrics) {
	this.metrics = metrics;
}
String model;
String vin;
Metadata metadata;
Perdayrent perdayrent;
Metrics metrics;


}
