package impl;

import com.zking.ssm.model.Book;
import com.zking.ssm.service.IBookService;
import com.zking.ssm.util.PageBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImplTest extends BaseTestCase {

    @Autowired
    private IBookService bookService;

    public void getUp(){
        super.setUp();
    }

    @Test
    public void insert() {
        book.setBookname("哈哈哈");
        book.setBooktype("啊哈");
        book.setPrice(1000f);
        bookService.insert(book);
    }

    @Test
    public void queryBookPager() {
        PageBean pageBean = new PageBean();
        List<Book> books = bookService.queryBookPager(book,pageBean);
        for (Book book1 : books) {
            System.out.println(book1);
        }
    }
}