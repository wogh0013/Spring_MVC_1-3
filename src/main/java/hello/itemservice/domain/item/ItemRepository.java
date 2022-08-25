package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository //컴포넌트 스캔의 대상이 됨
public class ItemRepository {

    //static, 아이템 저장소
    private static final Map<Long, Item> store = new HashMap<>();
    private static long sequence = 0L; //static

    //아이템 저장
    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    //아이템 하나 조회
    public Item findById(Long id){
        return store.get(id);
    }

    //아이템 전체 조회
    public List<Item> findAll(){
        //ArrayList<>()로 안전하게 감싸줌
        return new ArrayList<>(store.values());
    }

    //아이템 수정
    public void update(Long itemId, Item updateParam){
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    //테스트용 clear
    public void clearStore(){
        store.clear();
    }
}
