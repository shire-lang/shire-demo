// 引入整个模块
import * as fs from 'fs';
// 引入特定导出
import { readFileSync } from 'fs';
// 引入默认导出
import express from 'express';
// 引入类型
import type { SomeType } from './types';


class Orz {
    constructor(public name: string) {
    }
}

class Human extends Orz {
    constructor(name: string, public age: number) {
        super(name);
    }
}

class Man extends Human {
    constructor(name: string, age: number, public job: string) {
        super(name, age);
    }

    getAge() {
        return this.age;
    }

    format() {
        return this.getAge();
    }
}