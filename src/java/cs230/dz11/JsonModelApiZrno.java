/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs230.dz11;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

/**
 *
 * @author Filip
 */
@Named
@RequestScoped
public class JsonModelApiZrno {

    @Inject
    private Osoba osoba;

    @Inject
    private Adresa adresa;
    
    private String jsonStr;

    public String getJsonStr() {
        return jsonStr;
    }

    public void setJsonStr(String jsonStr) {
        this.jsonStr = jsonStr;
    }

    public String generateJson() {
//        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
//        JsonObject jsonObject = jsonObjectBuilder.
//                add("ime", osoba.getIme()).
//                add("prezime", osoba.getPrezime()).
//                add("pol", osoba.getPol()).
//                add("starost", osoba.getStarost()).
//                build();
        StringWriter stringWriter = new StringWriter();
        try (JsonGenerator jsonGenerator = Json.createGenerator(stringWriter)) {
//            jsonWriter.writeObject(jsonObject);
            jsonGenerator.writeStartObject().
                    write("brojIndeksa", osoba.getBrojIndeksa()).
                    write("ime", osoba.getIme()).
                    write("tradicionalni", osoba.getTradicionalni()).
                    write("ulica", adresa.getUlica()).
                    write("grad", adresa.getGrad()).
                    write("postanskiBroj", adresa.getPostanskiBroj()).
                    write("uloga", osoba.getUloga()).
                    writeEnd();
        }
        setJsonStr(stringWriter.toString());
        return "prikazi_popunjen_obj";
    }

    public String parseJson() {
//        JsonObject jsonObject;
//        try (JsonReader jsonReader = Json.createReader(new StringReader(jsonStr))) {
//            jsonObject = jsonReader.readObject();
//        }
//        osoba.setIme(jsonObject.getString("ime"));
//        osoba.setPrezime(jsonObject.getString("prezime"));
//        osoba.setPol(jsonObject.getString("pol"));
//        osoba.setStarost(jsonObject.getInt("starost"));
//        return "generisan_json";
        StringReader stringReader = new StringReader(jsonStr);
        JsonParser jsonParser = Json.createParser(stringReader);
        Map<String, Object> jsonMap = new HashMap<>();
        String jsonKeyNm = null;
        Object jsonVal = null;
        while (jsonParser.hasNext()) {
            JsonParser.Event event = jsonParser.next();
            if (event.equals(Event.KEY_NAME)) {
                jsonKeyNm = jsonParser.getString();
            } else if (event.equals(Event.VALUE_STRING)) {
                jsonVal = jsonParser.getString();
            } else if (event.equals(Event.VALUE_NUMBER)) {
                jsonVal = jsonParser.getInt();
            }
            jsonMap.put(jsonKeyNm, jsonVal);
        }

        osoba.setBrojIndeksa((String) jsonMap.get("brojIndeksa"));
        osoba.setIme((String) jsonMap.get("ime"));
        osoba.setTradicionalni((String) jsonMap.get("tradicionalni"));
        adresa.setUlica((String) jsonMap.get("ulica"));
        adresa.setGrad((String) jsonMap.get("grad"));
        adresa.setPostanskiBroj((String) jsonMap.get("postanskiBroj"));
        osoba.setUloga((String) jsonMap.get("uloga"));
        return "generisan_json";
    }
}
