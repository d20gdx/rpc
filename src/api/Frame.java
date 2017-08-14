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
   
   public Frame(String distance, String time, String lat, String l, String rSSI, String lSNR, String datarate,
         String gateway_EUI, String counter) {
      super();
      Distance = distance;
      Time = time;
      Lat = lat;
      Long = l;
      RSSI = rSSI;
      LSNR = lSNR;
      Datarate = datarate;
      Gateway_EUI = gateway_EUI;
      Counter = counter;
   }

   String Distance;
   String Time;
   String Lat;
   String Long;
   String RSSI;
   String LSNR;
   String Datarate;
   String Gateway_EUI;
   String Counter;
   /**
    * @return the distance
    */
   public String getDistance() {
      return Distance;
   }
   
   /**
    * @param distance the distance to set
    */
   public void setDistance(String distance) {
      Distance = distance;
   }
   
   /**
    * @return the time
    */
   public String getTime() {
      return Time;
   }
   
   /**
    * @param time the time to set
    */
   public void setTime(String time) {
      Time = time;
   }
   
   /**
    * @return the lat
    */
   public String getLat() {
      return Lat;
   }
   
   /**
    * @param lat the lat to set
    */
   public void setLat(String lat) {
      Lat = lat;
   }
   
   /**
    * @return the long
    */
   public String getLong() {
      return Long;
   }
   
   /**
    * @param l the long to set
    */
   public void setLong(String l) {
      Long = l;
   }
   
   /**
    * @return the rSSI
    */
   public String getRSSI() {
      return RSSI;
   }
   
   /**
    * @param rSSI the rSSI to set
    */
   public void setRSSI(String rSSI) {
      RSSI = rSSI;
   }
   
   /**
    * @return the lSNR
    */
   public String getLSNR() {
      return LSNR;
   }
   
   /**
    * @param lSNR the lSNR to set
    */
   public void setLSNR(String lSNR) {
      LSNR = lSNR;
   }
   
   /**
    * @return the datarate
    */
   public String getDatarate() {
      return Datarate;
   }
   
   /**
    * @param datarate the datarate to set
    */
   public void setDatarate(String datarate) {
      Datarate = datarate;
   }
   
   /**
    * @return the gateway_EUI
    */
   public String getGateway_EUI() {
      return Gateway_EUI;
   }
   
   /**
    * @param gateway_EUI the gateway_EUI to set
    */
   public void setGateway_EUI(String gateway_EUI) {
      Gateway_EUI = gateway_EUI;
   }
   
   /**
    * @return the counter
    */
   public String getCounter() {
      return Counter;
   }
   
   /**
    * @param counter the counter to set
    */
   public void setCounter(String counter) {
      Counter = counter;
   }


    
}
