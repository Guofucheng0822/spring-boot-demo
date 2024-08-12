package com.ps.gfc.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author guofucheng
 */
public class XmlUtil {
    public static final Logger log= LoggerFactory.getLogger(XmlUtil.class);

    public static String xml2json(String requestBody) {
        requestBody = StringUtils.trim(requestBody);
        XmlMapper xmlMapper = new XmlMapper();
        JsonNode node = null;
        try {
            node = xmlMapper.readTree(requestBody.getBytes());
            ObjectMapper jsonMapper = new ObjectMapper();
            return jsonMapper.writeValueAsString(node);
        } catch (Exception e) {
            log.error("xml 2 json error,msg:" + e.getMessage(), e);
        }
        return null;
    }
}
