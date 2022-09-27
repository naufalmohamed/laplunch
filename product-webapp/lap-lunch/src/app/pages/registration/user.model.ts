import { Address } from "./address.model";

export interface User {
    userEmailId: string;
    mobileNum: string;
    firstName: string;
    lastName: string;
    password: string;
    address: Address[];
}