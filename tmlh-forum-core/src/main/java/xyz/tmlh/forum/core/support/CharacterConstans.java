package xyz.tmlh.forum.core.support;

/**
 * <p>
 *    CharacterConstans
 * </p>
 *
 * @author TianXin
 * @since 2019年5月12日下午6:21:29
 */
public interface CharacterConstans {

    String GT = "&gt;";
    String GT2 = "&gt;&gt;";
    String LT = "&lt;";
    String LT2 = "&lt;&lt;";
    
    
    static String aLabel(String url ,String content) {
        return "<a href='"+url+"'>" +content+ "</a>";
    }
    
}
