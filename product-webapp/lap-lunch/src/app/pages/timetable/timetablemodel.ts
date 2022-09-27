export class Timetablemodel {

    timetableId!: String;
    userEmailId!:String;
    itemList!: MenuListModel[];
    weekDay!: String;

}

export class MenuListModel{

    itemId!: number;
    itemName!:String;
    itemCost!:number;
    
}
