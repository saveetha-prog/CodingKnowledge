/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
 #include<stdio.h>
 #include<math.h>

 int val;
 struct TreeNode* left;
 struct TreeNode* right;
 long long total_sum=0;
 long long max_prod=0;
 long long calculatetotalsum(struct TreeNode* root){
    if (root==NULL)
        return 0;
    return root->val+calculatetotalsum(root->left)+calculatetotalsum(root->right);
 }
 long long calculateproduct(struct TreeNode* root){
    if(root==NULL)
        return 0;
        long long current_subtree_sum=root->val+calculateproduct(root->left)+calculateproduct(root->right);
        long long current_prod=current_subtree_sum*(total_sum-current_subtree_sum);
        if(current_prod>max_prod){
            max_prod=current_prod;
        }
        return current_subtree_sum;
 }
int maxProduct(struct TreeNode* root) {
    total_sum=0;
    max_prod=0;
    total_sum=calculatetotalsum(root);
    calculateproduct(root);
    return (int)(max_prod%1000000007);
}