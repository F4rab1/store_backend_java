alter table wishlist
drop constraint fk_wishlist_on_product;

alter table wishlist
    add constraint fk_wishlist_on_product
        foreign key (product_id) references products
            on delete cascade;
