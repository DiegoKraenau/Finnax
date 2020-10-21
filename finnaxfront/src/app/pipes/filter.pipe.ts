import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(value: any, arg: any): any {
    const resultCustomers=[];
    for(const customer of value){
      if(customer.customerName.toLowerCase().indexOf(arg.toLowerCase())>-1){
         resultCustomers.push(customer);
      }
    }
    return resultCustomers;
  }

}
