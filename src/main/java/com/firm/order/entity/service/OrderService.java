package com.firm.order.entity.service;

import com.firm.order.entity.MyOrder;
import com.firm.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Service
@Path("order")
public class OrderService {
    @Autowired
    OrderRepository repo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
       List<MyOrder> orders = repo.findAll();
       if(orders!=null && orders.size()>0){
           return Response.status(200).entity(orders).build();
       }
       else{
           return Response.status(204).build();
       }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getById(@PathParam("id") int id){
        Optional<MyOrder> order = repo.findById(id);
        if(order.isPresent()){
            return Response.status(200).entity(order).build();
        }
        else{
            return Response.status(204).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(MyOrder order){
        MyOrder o = repo.save(order);
        if(o!=null){
            return Response.status(201).build();
        }
        else{
            return Response.status(500).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(MyOrder order){
        MyOrder o = repo.save(order);
        if(o!=null){
            return Response.status(201).build();
        }
        else{
            return Response.status(500).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id){
        repo.deleteById(id);
        return Response.status(200).build();

    }

    public void setRepo(OrderRepository repo) {
        this.repo = repo;
    }
}
