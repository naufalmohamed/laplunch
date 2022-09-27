import { WeekDay } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { menuModel } from 'src/app/profilepage/orders/ordersmodel';
import { Allitems } from '../Items/allitems';
import { ApiserviceService  } from '../menuapiservice/apiservice.service';
import { MenuListModel, Timetablemodel } from './timetablemodel';
import { MatSnackBar}from '@angular/material/snack-bar';

//import { Timetablemodel } from './timetablemodel';
@Component({
  selector: 'app-timetable',
  templateUrl: './timetable.component.html',
  styleUrls: ['./timetable.component.css']
})
export class TimetableComponent implements OnInit {

  ListofItems !: Allitems[];

  Add:boolean=true;

 addedItems: boolean[]=[];

 alert:boolean=false;
  userEmailId: any = sessionStorage.getItem('emailId');
  //userEmailId: string="hello@gmail.com";
  postMenumodel: MenuListModel = new MenuListModel();
  timetTableData!: Timetablemodel;
  timeTableList: Timetablemodel[]=[];
  menuListModel!:MenuListModel;
  menuList : MenuListModel[]=[];
  monList:MenuListModel[]=[];
  tueList:MenuListModel[]=[];
  wedList:MenuListModel[]=[];
  thursList:MenuListModel[]=[];
  friList:MenuListModel[]=[];
  satList:MenuListModel[]=[];
  sunList:MenuListModel[]=[];


  menuListMonday: MenuListModel[]=[];;

  indexVal!: number;

  selectedTimeTableId: String='';

  constructor(private serviceapi: ApiserviceService ,private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.serviceapi.getItem()
    .subscribe(res=>{
      this.ListofItems =res
      console.log(this.ListofItems);
    })

    this.serviceapi.getTimeTable()
    .subscribe(res=>{
      this.timeTableList=res
      console.log(this.timetTableData);
      
    })
    var i;
for(i=0; i<this. ListofItems.length; i++){
	this.addedItems.push(false)
}
  }

 

  addItems(index:number){

    this.menuListModel = new MenuListModel();

    this.menuListModel.itemId=this.ListofItems[index].itemId;
    this.menuListModel.itemName=this.ListofItems[index].itemName;

    this.menuListModel.itemCost=this.ListofItems[index].itemCost;
    // this.menuListModel.weekDay="MONDAY";
   
    console.log(this.menuListModel);
    //console.log(this.ListofItems[index]);
    
    

    this.menuList.push(this.menuListModel);
    this.Add= !this.Add;
    this.addedItems[index]=true;
  }
  

  // this._snackBar.open(message, action); ,message:string,action:string
  submitItems(day:string){

    this.timetTableData=new Timetablemodel();

    this.timetTableData.userEmailId=this.userEmailId;
    this.timetTableData.weekDay=day;
   console.log(this.userEmailId);
    //this.snackBar.open('Submitted', 'ok');
  
   
    this.timetTableData.itemList=this.menuList;

    this.serviceapi.postItemsToTimetable(this.timetTableData).subscribe(response=>{
      this.menuList=[];
    })
    this.alert=true;
   
    
  }
  closeAlert(){
    this.alert=false;
  }

  

  removeMondayItem(index: any){
    this.monList.splice(index,1)
    this.serviceapi.deleteTimeTableData(this.selectedTimeTableId,index).subscribe();
    console.log(this.menuList);

  }

  showMondayItems(){
    this.timeTableList.forEach((foo)=>{
      if(foo.weekDay=='MONDAY'){
        this.monList.push(...foo.itemList);
        this.selectedTimeTableId=foo.timetableId;
        console.log(this.monList)
      }
    })
    
  }
  onClickClose(){
    this.monList=[];
  }

  removeTuesdayItem(index: any){
    this.tueList.splice(index,1)
    this.serviceapi.deleteTimeTableData(this.selectedTimeTableId,index).subscribe();
    console.log(this.menuList);

  }

  showTuesdayItems(){
    this.timeTableList.forEach((foo)=>{
      if(foo.weekDay=='TUESDAY'){
        this.tueList.push(...foo.itemList);
        this.selectedTimeTableId=foo.timetableId;
        console.log(this.tueList)
      }
    })
  
  }

  onClickCloseTuesday(){
    this.tueList=[];
  }

  removeWednesdayItem(index: any){
    this.wedList.splice(index,1)
    this.serviceapi.deleteTimeTableData(this.selectedTimeTableId,index).subscribe();
    console.log(this.menuList);

  }

  showWednesdayItems(){
    this.timeTableList.forEach((foo)=>{
      if(foo.weekDay=='WEDNESDAY'){
        this.wedList.push(...foo.itemList);
        this.selectedTimeTableId=foo.timetableId;
        console.log(this.tueList)
      }
    })
  
  }

  onClickCloseWednesday(){
    this.wedList=[];
  }

  removeThursdayItem(index: any){
    this.thursList.splice(index,1)
    this.serviceapi.deleteTimeTableData(this.selectedTimeTableId,index).subscribe();
    console.log(this.menuList);

  }

  showThursdayItems(){
    this.timeTableList.forEach((foo)=>{
      if(foo.weekDay=='THURSDAY'){
        this.thursList.push(...foo.itemList);
        this.selectedTimeTableId=foo.timetableId;
        console.log(this.tueList)
      }
    })
  
  }
  onClickCloseThursday(){
    this.thursList=[];
  }

  removeFridayItem(index: any){
    this.friList.splice(index,1)
    this.serviceapi.deleteTimeTableData(this.selectedTimeTableId,index).subscribe();
    console.log(this.menuList);

  }

  showFridayItems(){
    this.timeTableList.forEach((foo)=>{
      if(foo.weekDay=='FRIDAY'){
        this.friList.push(...foo.itemList);
        this.selectedTimeTableId=foo.timetableId;
        console.log(this.tueList)
      }
    })
  
  }
  onClickCloseFriday(){
    this.friList=[];
  }
  
  removeSaturdayItem(index: any){
    this.satList.splice(index,1)
    this.serviceapi.deleteTimeTableData(this.selectedTimeTableId,index).subscribe();
    console.log(this.menuList);

  }

  showSaturdayItems(){
    this.timeTableList.forEach((foo)=>{
      if(foo.weekDay=='SATURDAY'){
        this.satList.push(...foo.itemList);
        this.selectedTimeTableId=foo.timetableId;
        console.log(this.tueList)
      }
    })
  
  }
  onClickCloseSaturday(){
    this.satList=[];
  }
  
  removeSundayItem(index: any){
    this.sunList.splice(index,1)
    this.serviceapi.deleteTimeTableData(this.selectedTimeTableId,index).subscribe();
    console.log(this.menuList);

  }

  showSundayItems(){
    this.timeTableList.forEach((foo)=>{
      if(foo.weekDay=='SUNDAY'){
        this.sunList.push(...foo.itemList);
        this.selectedTimeTableId=foo.timetableId;
        console.log(this.tueList)
      }
    })
  
  }

  onClickCloseSunday(){
    this.sunList=[];
  }
  
  
  






 }
