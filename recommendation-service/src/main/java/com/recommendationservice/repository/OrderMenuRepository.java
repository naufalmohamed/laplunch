package com.recommendationservice.repository;

//import com.recommendationservice.model.Menu;
import com.recommendationservice.model.OrderMenu;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import java.util.List;

public interface OrderMenuRepository extends Neo4jRepository<OrderMenu, Integer> {

    @Query("MATCH(m:OrderMenu)<-[rel:ITEMS_LIST]-(o:RelationshipModel{orderId:$id}) RETURN (m) LIMIT 2")
    List<OrderMenu> getByOrder(Long id);
}
