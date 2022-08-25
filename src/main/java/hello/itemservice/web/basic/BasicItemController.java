package hello.itemservice.web.basic;

import hello.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor //final이 붙은 키워드의 생성자를 만들어줌
public class BasicItemController {

    private final ItemRepository itemRepository;
}
