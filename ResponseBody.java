@SresponseBody
    @RequestMapping(value = "/rtInfomartion", method=RequestMethod.GET.produces = "application/text; charset=utf8")
    public String rtInfomartion(Locale locale, Model model) throws IOException{
        StringBuilder urlBuilder = new StringBuilder("http://openapi.tago.go.kr/openapi/service/BusLcInfoInqireService/getRouteAcctoBusLcList");

        urlBuilder.append("?"+URLEncoder.encode("ServiceKey","UTF-8")+"=NJPq5bgNwTn08ylVVjGuBpmtiwARPqc%2BUR4WPrIf5advbjU9WA1RrL1SIMjKUNhRHh2fKE8QOVUpf6%2FBu9lCpA%3D%3D");
        urlBuilder.append("&"+URLEncoder.encode("route_Id","UTF-8")+"="+URLEncoder.encode("CHB272000376","UTF-8"));
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type","application/xml;charset=UTF-8");

        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300){
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        }else{
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));

        }
        StringBuilder sb = new StringBuilder();
        String line;
        while((line=rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        return sb.toString();
    
}
