/*------------------------------------------------------------------------------
 *  The information contained herein is proprietary to and considered a
 *  trade secret of NGAHR Limited and shall not be reproduced,
 *  in whole or in part, without the written permission of NGAHR
 *  Limited. Within NGAHR, information must not be copied from this 
 *  document without the express permission of the Managing Director of 
 *  NGAHR.
 *
 *  Copyright NGAHR Limited 2017
------------------------------------------------------------------------------*/

package api;


/**
 * @author SRoderick
 *
 */
public class Frame {
   
	private String gw_lat;
	private String gw_lon;
	
	
	public String getGw_lat() {
		return gw_lat;
	}
	public void setGw_lat(String gw_lat) {
		this.gw_lat = gw_lat;
	}
	public String getGw_lon() {
		return gw_lon;
	}
	public void setGw_lon(String gw_lon) {
		this.gw_lon = gw_lon;
	}
	
	
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNet_type() {
		return net_type;
	}
	public void setNet_type(String net_type) {
		this.net_type = net_type;
	}
	public Frame(String time, String id, String net_type, String gw_lat, String gw_lon, String gw_alt,
			String gw_ant_type, String gw_location, String gw_comments, String node_lat, String node_long,
			String node_alt, String node_type, String node_location, String node_comments, String distance, String rssi,
			String lsnr, String datr, String counter_up, String gw_addr, String dev_addr, String port, String stat,
			String gw_band, String server_time, String modu, String chan, String gateway_time, String tmst, String codr,
			String rfch, String freq, String size, String dev_eui, String rx_time, String payload, String endoffile) {
		super();
		this.time = time;
		this.id = id;
		this.net_type = net_type;
		this.gw_lat = gw_lat;
		this.gw_lon = gw_lon;
		this.gw_alt = gw_alt;
		this.gw_ant_type = gw_ant_type;
		this.gw_location = gw_location;
		this.gw_comments = gw_comments;
		this.node_lat = node_lat;
		this.node_long = node_long;
		this.node_alt = node_alt;
		this.node_type = node_type;
		this.node_location = node_location;
		this.node_comments = node_comments;
		this.distance = distance;
		this.rssi = rssi;
		this.lsnr = lsnr;
		this.datr = datr;
		this.counter_up = counter_up;
		this.gw_addr = gw_addr;
		this.dev_addr = dev_addr;
		this.port = port;
		this.stat = stat;
		this.gw_band = gw_band;
		this.server_time = server_time;
		this.modu = modu;
		this.chan = chan;
		this.gateway_time = gateway_time;
		this.tmst = tmst;
		this.codr = codr;
		this.rfch = rfch;
		this.freq = freq;
		this.size = size;
		this.dev_eui = dev_eui;
		this.rx_time = rx_time;
		this.payload = payload;
		this.endoffile = endoffile;
	}
	

	
	
	
	public String getGw_alt() {
		return gw_alt;
	}
	public void setGw_alt(String gw_alt) {
		this.gw_alt = gw_alt;
	}
	public String getGw_ant_type() {
		return gw_ant_type;
	}
	public void setGw_ant_type(String gw_ant_type) {
		this.gw_ant_type = gw_ant_type;
	}
	public String getGw_location() {
		return gw_location;
	}
	public void setGw_location(String gw_location) {
		this.gw_location = gw_location;
	}
	public String getGw_comments() {
		return gw_comments;
	}
	public void setGw_comments(String gw_comments) {
		this.gw_comments = gw_comments;
	}
	public String getNode_lat() {
		return node_lat;
	}
	public void setNode_lat(String node_lat) {
		this.node_lat = node_lat;
	}
	public String getNode_long() {
		return node_long;
	}
	public void setNode_long(String node_long) {
		this.node_long = node_long;
	}
	public String getNode_alt() {
		return node_alt;
	}
	public void setNode_alt(String node_alt) {
		this.node_alt = node_alt;
	}
	public String getNode_type() {
		return node_type;
	}
	public void setNode_type(String node_type) {
		this.node_type = node_type;
	}
	public String getNode_location() {
		return node_location;
	}
	public void setNode_location(String node_location) {
		this.node_location = node_location;
	}
	public String getNode_comments() {
		return node_comments;
	}
	public void setNode_comments(String node_comments) {
		this.node_comments = node_comments;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getRssi() {
		return rssi;
	}
	public void setRssi(String rssi) {
		this.rssi = rssi;
	}
	public String getLsnr() {
		return lsnr;
	}
	public void setLsnr(String lsnr) {
		this.lsnr = lsnr;
	}
	public String getDatr() {
		return datr;
	}
	public void setDatr(String datr) {
		this.datr = datr;
	}
	public String getCounter_up() {
		return counter_up;
	}
	public void setCounter_up(String counter_up) {
		this.counter_up = counter_up;
	}
	public String getGw_addr() {
		return gw_addr;
	}
	public void setGw_addr(String gw_addr) {
		this.gw_addr = gw_addr;
	}
	public String getDev_addr() {
		return dev_addr;
	}
	public void setDev_addr(String dev_addr) {
		this.dev_addr = dev_addr;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	public String getGw_band() {
		return gw_band;
	}
	public void setGw_band(String gw_band) {
		this.gw_band = gw_band;
	}
	public String getServer_time() {
		return server_time;
	}
	public void setServer_time(String server_time) {
		this.server_time = server_time;
	}
	public String getModu() {
		return modu;
	}
	public void setModu(String modu) {
		this.modu = modu;
	}
	public String getChan() {
		return chan;
	}
	public void setChan(String chan) {
		this.chan = chan;
	}
	public String getGateway_time() {
		return gateway_time;
	}
	public void setGateway_time(String gateway_time) {
		this.gateway_time = gateway_time;
	}
	public String getTmst() {
		return tmst;
	}
	public void setTmst(String tmst) {
		this.tmst = tmst;
	}
	public String getCodr() {
		return codr;
	}
	public void setCodr(String codr) {
		this.codr = codr;
	}
	public String getRfch() {
		return rfch;
	}
	public void setRfch(String rfch) {
		this.rfch = rfch;
	}
	public String getFreq() {
		return freq;
	}
	public void setFreq(String freq) {
		this.freq = freq;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getDev_eui() {
		return dev_eui;
	}
	public void setDev_eui(String dev_eui) {
		this.dev_eui = dev_eui;
	}
	public String getRx_time() {
		return rx_time;
	}
	public void setRx_time(String rx_time) {
		this.rx_time = rx_time;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	public String getEndoffile() {
		return endoffile;
	}
	public void setEndoffile(String endoffile) {
		this.endoffile = endoffile;
	}
	String time;
	String id;
	String net_type;

	
	
	String gw_alt;
	String gw_ant_type;
	String gw_location;
	String gw_comments;
	String node_lat;
	String node_long;
	String node_alt;
	String node_type;
	String node_location;
	String node_comments;
	String distance;
	String rssi;
	String lsnr;
	String datr;
	String counter_up;
	String gw_addr;
	String dev_addr;
	String port;            
	String stat;            
	String gw_band;            
	String server_time;          
	String modu;            
	String chan;            
	String gateway_time;         
	String tmst;            
	String codr;            
	String rfch;            
	String freq;            
	String size;            
	String dev_eui;            
	String rx_time;            
	String payload;            
	String endoffile;   

    
}
