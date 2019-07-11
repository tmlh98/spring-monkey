package xyz.tmlh.forum.web.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * <p>
 *    
 * </p>
 *
 * @author TianXin
 * @since 2019年4月5日下午10:06:21
 */
public class LocalDateTimeUtil {

    /**
     * LocalDateTime转化为时间戳
      *
      * @param @param time
      * @param @return    参数
      * @return long    返回类型
      * @throws
     */
    public static Long toTimestamp(LocalDateTime time) {
        if(time == null) {
            return null;
        }
        return time.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }
    
    /**
     * 时间戳转化为LocalDateTime
     *
     * @param @param time
     * @param @return    参数
     * @return long    返回类型
     * @throws
     */
    public static LocalDateTime toLocalDateTime(Long time) {
        if(time == null) {
            return null;
        }
        return LocalDateTime.ofEpochSecond(time/1000,0,ZoneOffset.ofHours(8));
    }
    
}
