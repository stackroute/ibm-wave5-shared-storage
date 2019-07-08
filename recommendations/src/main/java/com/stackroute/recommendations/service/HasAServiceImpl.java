package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.Partition;
import com.stackroute.recommendations.domain.StorageUnit;
import com.stackroute.recommendations.repository.HasARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collection;

@Service
public class HasAServiceImpl implements HasAService
{
    HasARepository hasARepository;

    @Autowired
    public HasAServiceImpl(HasARepository hasARepository) {
        this.hasARepository = hasARepository;
    }

    @Override
    public StorageUnit createStorageUnitRelationship(long warehouseId, long pid) {
        return hasARepository.createRelationship(warehouseId,pid);
    }

        @Override
    public Collection<StorageUnit> recommendationCost() throws Exception {

        ArrayList<Long> list =hasARepository.getCost();
        ArrayList<Long> list1=hasARepository.getPartitionId();
        System.out.println(list);
        System.out.println(list1);

            //System.out.println("Inside Cost");

        Collection<Partition> collection=new ArrayList<>();
        //Collection<StorageUnit> collection1=new ArrayList<>();
        Collection<StorageUnit> finalList=new ArrayList<>();


            for(int i=0;i<list1.size();i++){
               // System.out.println(list1.get(i));
                for(int j=0;j<list.size();j++){
                    if(i==j){
                       // System.out.println( list.get(j));
                        if (list.get(j) >= 500 && list.get(j) <= 1000)
                        {
                            System.out.println( list.get(j));
                            System.out.println("Range 500-1000");
                            collection = hasARepository.recommendationCostRange0();
                        } else if (list.get(j) > 1000 && list.get(j) <= 2000) {
                            System.out.println("cost of Partition " + list.get(j));
                            System.out.println("Range 1000-2000");
                            collection = hasARepository.recommendationCostRange1();
                        } else if (list.get(j) > 2000 && list.get(j) <= 3000) {
                            System.out.println("cost of Partition " + list.get(j));
                            System.out.println("Range 2000-3000");
                            collection= hasARepository.recommendationCostRange2();
                        } else if (list.get(j) > 3000 && list.get(j) <= 4000) {
                            System.out.println("cost of Partition " + list.get(j));
                            System.out.println("Range 3000-4000");
                            collection= hasARepository.recommendationCostRange3();
                        } else if (list.get(j) > 4000 && list.get(j) <= 5000) {
                            System.out.println("cost of Partition " + list.get(j));
                            System.out.println("Range 4000-5000");
                            collection= hasARepository.recommendationCostRange4();
                        } else if (list.get(j) > 5000 && list.get(j) <= 6000) {
                            System.out.println("cost of Partition " + list.get(j));
                            System.out.println("Range 5000-6000");
                            collection= hasARepository.recommendationCostRange5();
                        }else if (list.get(j) > 6000 && list.get(j) <= 7000) {
                            System.out.println("cost of Partition " + list.get(j));
                            System.out.println("Range 6000-7000");
                            collection= hasARepository.recommendationCostRange6();
                        }else if (list.get(j) > 7000 && list.get(j) <= 8000) {
                            System.out.println("Range 7000-8000");
                            collection= hasARepository.recommendationCostRange7();
                        }else if (list.get(j) > 8000 && list.get(j) <= 9000) {
                            System.out.println("cost of Partition " + list.get(j));
                            System.out.println("Range 8000-9000");
                            collection= hasARepository.recommendationCostRange8();
                        }else if (list.get(j) > 9000 && list.get(j) <= 10000) {
                            System.out.println("cost of Partition " + list.get(j));
                            System.out.println("Range 9000-10000");
                            collection= hasARepository.recommendationCostRange9();
                        }

                    }
                }
            }
            //System.out.println(finalList);
            return finalList;

    }
}
