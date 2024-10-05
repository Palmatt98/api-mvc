package it.api_mvc.repository;

import it.api_mvc.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Integer> {
    // Questa è una query generata dal nome del metodo
    //SELECT * FROM automobili WHERE automobili.carburante = "benzina"
    List<Auto> findByCarburante(String carburante);

    List<Auto> findByMarca(String marca);

    //La query la puoi scrivere anche a mano, tenendo conto della sintassi JPQL
    //Se vuoi scrivere la query in SQL nativo devi fare @Query(".......la tua query", nativeQuery = true)
    //FROM Auto ----------> Auto é il nome del model, mentre 'a' é l'identificatore
    @Query("SELECT a FROM Auto a WHERE a.hp = :hp AND a.modello = :modello")
    List<Auto> dammiLeAutoConHpAndModello(int hp, String modello);

}
