export class Purchase{
    purchaseId: string;
    purchaseName:string; 
    purchaseAmount:number;
    deliveryAmount:number
    purchaseProductsName:string
    purchaseProductsAmount:number
    operationDate:string
    operationId:string;
    customerId:string;
    listaProducts:Array<{productId: string, productDescription: string,productAmount:number}>;
}