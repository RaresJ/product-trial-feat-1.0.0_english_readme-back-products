import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Product } from './product.class';
import { privateDecrypt } from 'crypto';
import { log } from 'console';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

    private productsUrl: string;
    private static productslist: Product[] = null;
    private products$: BehaviorSubject<Product[]> = new BehaviorSubject<Product[]>([]);

    constructor(private http: HttpClient) {
        this.productsUrl = "http://localhost:8080/products"
     }

    getProducts(): Observable<Product[]> {
        this.http.get<Product[]>(this.productsUrl).subscribe(data => {
            ProductsService.productslist = data;
            
            this.products$.next(ProductsService.productslist);
        });
        
        return this.products$;
    }

    create(prod: Product): Observable<Product[]> {
        console.log(prod);
        this.http.post<Product>(this.productsUrl, prod).subscribe(data => {
            console.log("Product created" + data)
        })

        return this.products$;
    }

    update(prod: Product): Observable<Product[]>{
        this.http.patch<Product>(this.productsUrl + "/" + prod.id, prod).subscribe(data => {
            console.log("Product updated" + data)
        })
        
        return this.products$;
    }


    delete(id: number): Observable<Product[]>{
        this.http.delete<any>(this.productsUrl + "/" + id).subscribe(data => {
            console.log("Product deleted" + data)
        })
        
        return this.products$;
    }
}