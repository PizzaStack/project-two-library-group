import {PatronComponent} from './patron/patron.component';

export class book{
    constructor(
    public bookId: number,
    public title: string,
    public author: string,
    public ibsn: number,
    public keyword1: number,
    public keyword2: number,
    public keyword3: number,
    public coverImageUrl: string,
    public description: string,
    public patron: PatronComponent,
    public checkedOutDate: string
    ){}
}