package de.conio.conio.connector.jpa.behaviour.service.search;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.conio.conio.model.post.tutorial.Tutorial;

@Service
public class TutorialSearchService {

    @Autowired
    private final EntityManager entityManager;


    @Autowired
    public TutorialSearchService(EntityManager entityManager) {
        super();
        this.entityManager = entityManager;
    }


    public void initializeHibernateSearch() {

        try {
            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
            fullTextEntityManager.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public List<Tutorial> fuzzySearch(String searchTerm) {

        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Tutorial.class).get();
        Query luceneQuery = qb.keyword().fuzzy().withPrefixLength(1).onFields("title")
                .matching(searchTerm).createQuery();

        javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, Tutorial.class);

        // execute search

        List<Tutorial> tutorialList = null;
        try {
            tutorialList = jpaQuery.getResultList();
        } catch (NoResultException nre) {
            ;// do nothing

        }

        return tutorialList;


    }
}