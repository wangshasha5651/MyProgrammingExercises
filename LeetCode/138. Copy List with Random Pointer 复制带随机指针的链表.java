    public static HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        RandomListNode tmphead = new RandomListNode(head.label);

        // 把next顺序复制
        RandomListNode newhead = findNext(head, tmphead);

        // 依次找到random
        findRandom(head, newhead);

        return newhead;
    }

    public RandomListNode findNext(RandomListNode now, RandomListNode fresh){
        fresh.next = new RandomListNode(0);
        if(now.next == null){
            RandomListNode node = new RandomListNode(now.label);
            node.next = null;
            map.put(now, node);
            return node;
        }
        RandomListNode node = findNext(now.next, fresh.next);
        fresh.label = now.label;
        fresh.next = node;
        map.put(now, fresh);
        return fresh;
    }

    public void findRandom(RandomListNode now, RandomListNode fresh){
        RandomListNode tmpnow = now;
        RandomListNode tmpfresh = fresh;
        while(tmpnow != null && tmpfresh != null){
            if(tmpnow.random == null){
                tmpfresh.random = null;
            }else{
                tmpfresh.random = map.get(tmpnow.random);
            }
            if(tmpnow.next == null || tmpfresh.next == null){
                break;
            }
            tmpnow = tmpnow.next;
            tmpfresh = tmpfresh.next;
        }

    }