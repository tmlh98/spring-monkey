package xyz.tmlh.core.suport;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 
 * <p>
 * Title: PageInfo
 * </p>
 * <p>
 * Description: Page 增强 ,增加所有导航页号
 * </p>
 * 
 * @author TianXin
 * @created 2019年2月26日 下午7:58:07
 * @modified [who date description]
 * @check [who date description]
 * @param <T>
 */
public class PageInfo<T> extends Page<T> {

    private static final long serialVersionUID = 6117385340307958793L;

    public PageInfo(int current, int size) {
        super(current, size);
    }

    // 导航页码数
    private int navigatePages;
    // 所有导航页号
    private int[] navigatepageNums;

    /**
     * 获取所有导航页号
     * 
     * @author TianXin
     * @created 2019年2月26日 下午8:06:57
     * @return
     */
    public int[] getNavigatepageNums() {
        if (getPages() <= navigatePages) {
            navigatepageNums = new int[navigatePages];
            for (int i = 0; i < navigatePages; i++) {
                navigatepageNums[i] = i + 1;
            }
        } else { // 当总页数大于导航页码数时
            navigatepageNums = new int[navigatePages];
            int startNum = (int)(getCurrent() - navigatePages / 2);
            int endNum = (int)(getCurrent() + navigatePages / 2);

            if (startNum < 1) {
                startNum = 1;
                // (最前navigatePages页
                for (int i = 0; i < navigatePages; i++) {
                    navigatepageNums[i] = startNum++;
                }
            } else if (endNum > getPages()) {
                endNum = (int)getPages();
                // 最后navigatePages页
                for (int i = navigatePages - 1; i >= 0; i--) {
                    navigatepageNums[i] = endNum--;
                }
            } else {
                // 所有中间页
                for (int i = 0; i < navigatePages; i++) {
                    navigatepageNums[i] = startNum++;
                }
            }
        }
        return navigatepageNums;
    }

    public int getNavigatePages() {
        return navigatePages;
    }

    public void setNavigatePages(int navigatePages) {
        if (getPages() < navigatePages) {
            this.navigatePages = (int)getPages();
        } else {
            this.navigatePages = navigatePages;
        }
    }

    public void setNavigatepageNums(int[] navigatepageNums) {
        this.navigatepageNums = navigatepageNums;
    }

    @Override
    public long getPages() {
        return super.getPages();
    }

}